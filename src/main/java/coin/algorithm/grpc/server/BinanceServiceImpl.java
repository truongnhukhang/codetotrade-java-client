package coin.algorithm.grpc.server;

import coin.algorithm.domain.TradeMetadata;
import coin.algorithm.domain.*;
import coin.algorithm.exchange.binance.BinanceFutureConnector;
import coin.algorithm.grpc.service.Signal;
import coin.algorithm.grpc.service.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.grpc.stub.StreamObserver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.ta4j.core.BarSeries;
import org.ta4j.core.BaseBar;

import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

public class BinanceServiceImpl extends CoinAlgorithmServiceGrpc.CoinAlgorithmServiceImplBase {
  String apiKey;
  String secretKey;
  Class<? extends BaseBot> botClass;
  Map<String, BaseBot> botMap;
  private static final Logger logger = LoggerFactory.getLogger(BinanceServiceImpl.class);
  boolean isTest = false;
  BinanceFutureConnector accountConnector;
  BinanceFutureConnector exchangeConnector;

  public BinanceServiceImpl(
      String apiKey, String secretKey, Class<? extends BaseBot> botClass, boolean isTestNet) {
    this.apiKey = apiKey;
    this.secretKey = secretKey;
    this.botClass = botClass;
    this.botMap = new HashMap<>();
    this.accountConnector = new BinanceFutureConnector(apiKey, secretKey, isTestNet);
    exchangeConnector = new BinanceFutureConnector(apiKey, secretKey, isTestNet);
  }

  @Override
  public void getOrderStatus(
      GetOrderStatusRequest request, StreamObserver<GetOrderStatusResponse> responseObserver) {
    String orderId = request.getOrderId();
    String symbol = request.getSymbol();
    String payload = "";
    GetOrderStatusResponse.Builder orderStatusBuilder = GetOrderStatusResponse.newBuilder();
    OrderStatus status = OrderStatus.NEW;
    // get order status from exchange
    try {
      var rs = accountConnector.getOrderStatus(symbol, orderId);
      payload = new ObjectMapper().writeValueAsString(rs);
      if (!rs.get("status").toString().equalsIgnoreCase("NEW")) {
        status = OrderStatus.FILLED;
      }
    } catch (JsonProcessingException e) {
      orderStatusBuilder.setIsSuccess(false);
    }
    orderStatusBuilder.setPayload(payload);
    GetOrderStatusResponse orderStatusResponse = orderStatusBuilder.setStatus(status).build();
    responseObserver.onNext(orderStatusResponse);
    responseObserver.onCompleted();
  }

  @Override
  public void streamCandle(
      StreamCandleRequest request, StreamObserver<StreamCandleResponse> responseObserver) {
    long lastPing = System.currentTimeMillis();
    String onlineId = request.getOnlineId();
    BaseBot baseBot = botMap.get(onlineId);
    BarSeries barSeries = baseBot.getBarSeries();
    Map<Duration, BarSeries> otherBarSeries = baseBot.getOtherBarSeries();
    Map<Duration, BarSeries> btcDomBarSeries = baseBot.getBtcDomBarSeries();
    String symbol = baseBot.getCoinInfo().getSymbol();
    List<Integer> durations =
        otherBarSeries.keySet().stream().map(d -> (int) d.toMinutes()).collect(Collectors.toList());
    durations.add((int) barSeries.getFirstBar().getTimePeriod().toMinutes());
    durations = durations.stream().distinct().collect(Collectors.toList());

    Map<String, List<Integer>> symbolDurations = new HashMap<>();
    symbolDurations.put(symbol, durations);
    symbolDurations.put(
        "btcdomusdt", btcDomBarSeries.keySet().stream().map(d -> (int) d.toMinutes()).toList());
    exchangeConnector.subscribeCandleEvent(
        symbolDurations,
        message -> {
          Candle candle = BinanceFutureConnector.fromCandleStickEvent(message);
          if (candle.getSymbol().equalsIgnoreCase(symbol)) {
            updateBarSeries(barSeries, candle);
            otherBarSeries.forEach(
                (key, value) -> {
                  updateBarSeries(value, candle);
                });
          }
          if (candle.getSymbol().toLowerCase().contains("btcdom")) {
            btcDomBarSeries.forEach(
                (key, value) -> {
                  updateBarSeries(value, candle);
                });
          }
          if (Instant.ofEpochMilli(lastPing).plusSeconds(5).isBefore(Instant.now())) {
            BaseBar lastBar = (BaseBar) barSeries.getLastBar();
            logger.info(
                "Last bar time: %s, close price: %s"
                    .formatted(lastBar.getEndTime(), lastBar.getClosePrice()));
          }
          responseObserver.onNext(StreamCandleResponse.newBuilder().setCandle(candle).build());
        },
        err -> {
          logger.error("Error when stream %s candle {}".formatted(symbol), err);
        },
        open -> {
          logger.info("Stream candle open {}", open);
        },
        close -> {
          logger.info("Stream candle close {}", close);
        });
  }

  private void updateBarSeries(BarSeries barSeries, Candle candle) {
    // check candle is same duration with barSeries
    if (barSeries.getLastBar().getTimePeriod().toMinutes() == candle.getDuration()) {
      boolean isReplace =
          candle.getEndTime() <= barSeries.getLastBar().getEndTime().toInstant().toEpochMilli();
      barSeries.addBar(
          new BaseBar(
              Duration.ofMinutes(candle.getDuration()),
              ZonedDateTime.ofInstant(Instant.ofEpochMilli(candle.getEndTime()), ZoneId.of("UTC")),
              candle.getOpen(),
              candle.getHigh(),
              candle.getLow(),
              candle.getClose(),
              candle.getVolume()),
          isReplace);
    }
  }

  @Override
  public void createOnlineRun(
      CreateOnlineRunRequest request, StreamObserver<CreateOnlineResponse> responseObserver) {
    try {
      String onlineId = UUID.randomUUID().toString();
      BackTestData backTestData = new BackTestData();
      // set all the fields of backTestData from request
      backTestData.setCoinInfo(
          new CoinInfo(
              request.getSymbol(),
              request.getPricePrecision(),
              request.getQuantityPrecision(),
              request.getTickSize()));
      List<Candle> mainCandles =
          exchangeConnector.getRecentCandle(
              request.getSymbol(),
              BinanceFutureConnector.durationToString(request.getMainInterval()),
              request.getInitBar());
      backTestData.setBarSeries(BackTestData.fromCandles(mainCandles));
      Map<Integer, Candles> otherCandles = new HashMap<>();
      Map<Integer, Candles> btcDoomCandles = new HashMap<>();
      for (Integer interval : request.getOtherIntervalsList()) {
        List<Candle> candles =
            exchangeConnector.getRecentCandle(
                request.getSymbol(),
                BinanceFutureConnector.durationToString(interval),
                request.getInitBar());
        BarSeries barSeries = BackTestData.fromCandles(candles);
        backTestData.getOtherBarSeries().put(Duration.ofMinutes(interval), barSeries);
        otherCandles.put(interval, Candles.newBuilder().addAllCandles(candles).build());
      }
      for (Integer interval : request.getBtcDomIntervalsList()) {
        List<Candle> candles =
            exchangeConnector.getRecentCandle(
                "BTCDOMUSDT",
                BinanceFutureConnector.durationToString(interval),
                request.getInitBar());
        BarSeries barSeries = BackTestData.fromCandles(candles);
        backTestData.getBtcDomBarSeries().put(Duration.ofMinutes(interval), barSeries);
        btcDoomCandles.put(interval, Candles.newBuilder().addAllCandles(candles).build());
      }
      backTestData.setBotConfig(
          new BotConfig(
              request.getBotOrderType(),
              request.getIsEnableCloseMode(),
              request.getInitBar(),
              request.getInitBalance(),
              request.getMakerFee(),
              request.getTakerFee()));
      // create bot instance
      BaseBot baseBot = this.botClass.getDeclaredConstructor().newInstance();
      baseBot.setCoinInfo(backTestData.getCoinInfo());
      baseBot.setBarSeries(backTestData.getBarSeries());
      baseBot.setBtcDomBarSeries(backTestData.getBtcDomBarSeries());
      baseBot.setOtherBarSeries(backTestData.getOtherBarSeries());
      baseBot.setBotConfig(backTestData.getBotConfig());
      baseBot.init(request.getConfigMap());
      botMap.put(onlineId, baseBot);
      responseObserver.onNext(
          CreateOnlineResponse.newBuilder()
              .setOnlineId(onlineId)
              .setCandles(Candles.newBuilder().addAllCandles(mainCandles))
              .putAllCandleMap(otherCandles)
              .putAllBtcDomCandleMap(btcDoomCandles)
              .build());
      responseObserver.onCompleted();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public void getSignal(
      GetSignalRequest request, StreamObserver<GetSignalResponse> responseObserver) {
    String onlineId = request.getOnlineId();
    int idx = request.getIdx();
    BaseBot baseBot = botMap.get(onlineId);
    responseObserver.onNext(
        GetSignalResponse.newBuilder()
            .setSignal(
                Signal.newBuilder()
                    .setIsBuy(baseBot.isBuy(idx))
                    .setIsSell(baseBot.isSell(idx))
                    .setIsCloseBuy(baseBot.isCloseBuyPosition(idx))
                    .setIsCloseSell(baseBot.isCloseSellPosition(idx))
                    .build())
            .build());
    responseObserver.onCompleted();
  }

  @Override
  public void getTradeMetadata(
      GetTradeMetadataRequest request, StreamObserver<GetTradeMetadataResponse> responseObserver) {
    try {
      String onlineId = request.getOnlineId();
      BaseBot baseBot = botMap.get(onlineId);
      int type = request.getTradeType();
      TradeMetadata tradeMetadata = null;
      if (type == 1) {
        tradeMetadata = baseBot.buy(baseBot.getBarSeries().getEndIndex());
      } else if (type == 2) {
        tradeMetadata = baseBot.sell(baseBot.getBarSeries().getEndIndex());
      }
      coin.algorithm.grpc.service.TradeMetadata protoTradeMetadata =
          ProtoConverter.toProtoTradeMetadata(tradeMetadata);
      responseObserver.onNext(
          GetTradeMetadataResponse.newBuilder().setTradeMetadata(protoTradeMetadata).build());
      responseObserver.onCompleted();
    } catch (Exception e) {
      responseObserver.onError(e);
    }
  }

  @Override
  public void createOrder(
      CreateOrderRequest request, StreamObserver<CreateOrderResponse> responseObserver) {
    // create order use exchange connector
    var responseBuilder = CreateOrderResponse.newBuilder();
    String payload = "";
    try {
      String orderId = request.getOrderId();
      String symbol = request.getSymbol();
      String price = request.getPrice();
      String quantity = request.getQuantity();
      OrderSide side = request.getSide();
      OrderType type = request.getType();
      Map<String, Object> rs = null;
      if (type.equals(OrderType.MARKET)) {
        rs = placeMarketOrder(symbol, quantity, isTest, orderId, side);
      } else if (type.equals(OrderType.LIMIT)) {
        rs = placeLimitOrder(symbol, price, quantity, isTest, orderId, side);
      } else if (type.equals(OrderType.SL_MARKET)) {
        rs = placeStopLossOrder(symbol, price, quantity, isTest, orderId, side);
      } else if (type.equals(OrderType.TP_MARKET)) {
        rs = placeTakeProfitOrder(symbol, price, quantity, isTest, orderId, side);
      }
      responseBuilder.setIsSuccess(true);
      payload = new ObjectMapper().writeValueAsString(rs);
      var status = rs.get("status").toString();
      var executedPrice = rs.get("avgPrice").toString();
      responseBuilder.setExecutedPrice(executedPrice);
      responseBuilder.setPayload(payload);
      responseBuilder.setStatus(status);
      responseBuilder.setOrderId((String) rs.get("clientOrderId"));
    } catch (Exception e) {
      responseBuilder.setIsSuccess(false);
      responseBuilder.setPayload(e.getMessage());
    } finally {
      responseObserver.onNext(responseBuilder.build());
      responseObserver.onCompleted();
    }
  }

  private Map<String, Object> placeMarketOrder(
      String symbol, String quantity, boolean isTest, String orderId, OrderSide side)
      throws Exception {
    return side.equals(OrderSide.BUY)
        ? accountConnector.placeMarketBuyOrder(symbol, quantity, isTest, orderId)
        : accountConnector.placeMarketSellOrder(symbol, quantity, isTest, orderId);
  }

  private Map<String, Object> placeLimitOrder(
      String symbol, String price, String quantity, boolean isTest, String orderId, OrderSide side)
      throws Exception {
    return side.equals(OrderSide.BUY)
        ? accountConnector.placeLimitBuyOrder(symbol, quantity, price, isTest, orderId)
        : accountConnector.placeLimitSellOrder(symbol, quantity, price, isTest, orderId);
  }

  private Map<String, Object> placeStopLossOrder(
      String symbol, String price, String quantity, boolean isTest, String orderId, OrderSide side)
      throws Exception {
    return side.equals(OrderSide.BUY)
        ? accountConnector.placeBuyTakeStopLossOrder(symbol, quantity, price, isTest, orderId)
        : accountConnector.placeSellTakeStopLossOrder(symbol, quantity, price, isTest, orderId);
  }

  private Map<String, Object> placeTakeProfitOrder(
      String symbol, String price, String quantity, boolean isTest, String orderId, OrderSide side)
      throws Exception {
    return side.equals(OrderSide.BUY)
        ? accountConnector.placeBuyTakeProfitOrder(symbol, quantity, price, isTest, orderId)
        : accountConnector.placeSellTakeProfitOrder(symbol, quantity, price, isTest, orderId);
  }

  @Override
  public void cancelOrder(
      CancelOrderRequest request, StreamObserver<CancelOrderResponse> responseObserver) {
    // cancel order use exchange connector
    var responseBuilder = CancelOrderResponse.newBuilder();
    String payload = "";
    try {
      String orderId = request.getOrderId();
      String symbol = request.getSymbol();
      Map<String, Object> rs = accountConnector.cancelOrder(symbol, orderId);
      responseBuilder.setIsSuccess(true);
      payload = new ObjectMapper().writeValueAsString(rs);
      responseBuilder.setPayload(payload);
    } catch (Exception e) {
      responseBuilder.setIsSuccess(false);
    } finally {
      responseObserver.onNext(responseBuilder.build());
      responseObserver.onCompleted();
    }
  }
}
