package coin.algorithm.grpc.server;


import coin.algorithm.domain.BackTestData;
import coin.algorithm.domain.BaseBot;
import coin.algorithm.domain.BotConfig;
import coin.algorithm.domain.CoinInfo;
import coin.algorithm.grpc.service.*;
import io.grpc.stub.StreamObserver;
import org.ta4j.core.Bar;
import org.ta4j.core.BarSeries;
import org.ta4j.core.Indicator;
import org.ta4j.core.num.Num;

import java.lang.reflect.InvocationTargetException;
import java.time.Duration;
import java.util.*;
import java.util.stream.Collectors;

public class BackTestServiceImpl extends CoinAlgorithmServiceGrpc.CoinAlgorithmServiceImplBase {
    Class<? extends BaseBot> botClass;
    Map<UUID, BackTestData> backTestDataMap = new HashMap<>();

    public BackTestServiceImpl(Class<? extends BaseBot> botClass) {
        this.botClass = botClass;
    }

    @Override
    public void createBackTest(CreateBackTestRequest request, StreamObserver<CreateBackTestResponse> responseObserver) {
        UUID uuid = UUID.randomUUID();
        // Convert CreateBackTestRequest to BackTestData
        BackTestData backTestData = new BackTestData();
        // set all the fields of backTestData from request
        backTestData.setCoinInfo(new CoinInfo(request.getSymbol(),
                                              request.getPricePrecision(),
                                              request.getQuantityPrecision(),
                                              request.getTickSize()));
        backTestData.setBarSeries(BackTestData.fromCandles(request.getCandles().getCandlesList()));
        backTestData.setOtherBarSeries(request.getCandleMapMap().entrySet().stream()
                                              .collect(Collectors.toMap(e -> Duration.ofMinutes(e.getKey()),
                                                                        e -> BackTestData.fromCandles(e.getValue()
                                                                                                       .getCandlesList()))));
        backTestData.setBtcDomBarSeries(request.getBtcDomCandleMapMap().entrySet().stream()
                                               .collect(Collectors.toMap(e -> Duration.ofMinutes(e.getKey()),
                                                                         e -> BackTestData.fromCandles(e.getValue()
                                                                                                        .getCandlesList()))));
        backTestData.setBotConfig(new BotConfig(request.getBotOrderType(),
                                                request.getIsEnableCloseMode(),
                                                request.getInitBar(),
                                                request.getInitBalance(),
                                                request.getMakerFee(),
                                                request.getTakerFee()));
        backTestDataMap.put(uuid, backTestData);
        CreateBackTestResponse response = CreateBackTestResponse.newBuilder().setBackTestId(uuid.toString()).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getTimeTravel(GetTimeTravelRequest request, StreamObserver<GetTimeTravelResponse> responseObserver) {
        BackTestData backTestData = backTestDataMap.get(UUID.fromString(request.getBackTestId()));
        try {
            BaseBot baseBot = this.botClass.getDeclaredConstructor().newInstance();
            baseBot.setCoinInfo(backTestData.getCoinInfo());
            baseBot.setBarSeries(backTestData.getBarSeries());
            baseBot.setBtcDomBarSeries(backTestData.getBtcDomBarSeries());
            baseBot.setOtherBarSeries(backTestData.getOtherBarSeries());
            baseBot.setBotConfig(backTestData.getBotConfig());
            baseBot.init(request.getConfigMap());
            var rs = baseBot.timeTravel();
            var charts = baseBot.getChartList();
            GetTimeTravelResponse response = GetTimeTravelResponse.newBuilder().addAllBuySell(rs.getBuySell())
                                                                  .addAllTradeMetadata(rs.getMetadata().stream()
                                                                                         .map(ProtoConverter::toProtoTradeMetadata)
                                                                                         .collect(Collectors.toList()))
                                                                  .setChartList(ChartList.newBuilder()
                                                                                         .addAllCharts(charts.stream()
                                                                                                             .map(c -> ProtoConverter.toProtoChart(
                                                                                                                     c,
                                                                                                                     backTestData))
                                                                                                             .collect(
                                                                                                                     Collectors.toList())))
                                                                  .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                 NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

    }




}
