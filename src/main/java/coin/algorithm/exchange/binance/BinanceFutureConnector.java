package coin.algorithm.exchange.binance;

import coin.algorithm.grpc.service.Candle;
import com.binance.connector.futures.client.WebsocketClient;
import com.binance.connector.futures.client.enums.DefaultUrls;
import com.binance.connector.futures.client.impl.UMFuturesClientImpl;
import com.binance.connector.futures.client.impl.UMWebsocketClientImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.Duration;
import java.util.*;
import java.util.function.Consumer;

public class BinanceFutureConnector {
    UMFuturesClientImpl client = null;
    WebsocketClient wsClient = null;
    String BUY = "BUY";
    String SELL = "SELL";
    static final int MAX_SIZE = 1500;

    public BinanceFutureConnector(String apiKey, String secretKey) {
        client = new UMFuturesClientImpl(apiKey, secretKey);
        wsClient = new UMWebsocketClientImpl();
    }

    public void close() {
        try {
            wsClient.closeAllConnections();
            ((UMWebsocketClientImpl) wsClient).close();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public BinanceFutureConnector(String apiKey, String secretKey, boolean isTestNet) {
        if(isTestNet) {
            client = new UMFuturesClientImpl(apiKey, secretKey, DefaultUrls.TESTNET_URL);
            wsClient = new UMWebsocketClientImpl(DefaultUrls.TESTNET_WSS_URL);
        } else {
            client = new UMFuturesClientImpl(apiKey, secretKey);
            wsClient = new UMWebsocketClientImpl();
        }

    }

    /**
     * |-------------------------|---------|-----------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
     * | Name                    | Type    | Mandatory | Description                                                                                                                                                                                                                                                                        |
     * | symbol                  | STRING  | YES       |                                                                                                                                                                                                                                                                                    |
     * | side                    | ENUM    | YES       |                                                                                                                                                                                                                                                                                    |
     * | positionSide            | ENUM    | NO        | Default BOTH for One-way Mode ; LONG or SHORT for Hedge Mode. It must be sent in Hedge Mode.                                                                                                                                                                                       |
     * | type                    | ENUM    | YES       |                                                                                                                                                                                                                                                                                    |
     * | timeInForce             | ENUM    | NO        |                                                                                                                                                                                                                                                                                    |
     * | quantity                | DECIMAL | NO        | Cannot be sent with closePosition=true(Close-All)                                                                                                                                                                                                                                  |
     * | reduceOnly              | STRING  | NO        | "true" or "false". default "false". Cannot be sent in Hedge Mode; cannot be sent with closePosition=true                                                                                                                                                                           |
     * | price                   | DECIMAL | NO        |                                                                                                                                                                                                                                                                                    |
     * | newClientOrderId        | STRING  | NO        | A unique id among open orders. Automatically generated if not sent. Can only be string following the rule: ^[\.A-Z\:/a-z0-9_-]{1,36}$                                                                                                                                              |
     * | stopPrice               | DECIMAL | NO        | Used with STOP/STOP_MARKET or TAKE_PROFIT/TAKE_PROFIT_MARKET orders.                                                                                                                                                                                                               |
     * | closePosition           | STRING  | NO        | true, false；Close-All，used with STOP_MARKET or TAKE_PROFIT_MARKET.                                                                                                                                                                                                               |
     * | activationPrice         | DECIMAL | NO        | Used with TRAILING_STOP_MARKET orders, default as the latest price(supporting different workingType)                                                                                                                                                                               |
     * | callbackRate            | DECIMAL | NO        | Used with TRAILING_STOP_MARKET orders, min 0.1, max 5 where 1 for 1%                                                                                                                                                                                                               |
     * | workingType             | ENUM    | NO        | stopPrice triggered by: "MARK_PRICE", "CONTRACT_PRICE". Default "CONTRACT_PRICE"                                                                                                                                                                                                   |
     * | priceProtect            | STRING  | NO        | "TRUE" or "FALSE", default "FALSE". Used with STOP/STOP_MARKET or TAKE_PROFIT/TAKE_PROFIT_MARKET orders.                                                                                                                                                                           |
     * | newOrderRespType        | ENUM    | NO        | "ACK", "RESULT", default "ACK"                                                                                                                                                                                                                                                     |
     * | priceMatch              | ENUM    | NO        | only avaliable for LIMIT/STOP/TAKE_PROFIT order; can be set to OPPONENT/ OPPONENT_5/ OPPONENT_10/ OPPONENT_20: /QUEUE/ QUEUE_5/ QUEUE_10/ QUEUE_20; Can't be passed together with price                                                                                            |
     * | selfTradePreventionMode | ENUM    | NO        | NONE:No STP / EXPIRE_TAKER:expire taker order when STP triggers/ EXPIRE_MAKER:expire taker order when STP triggers/ EXPIRE_BOTH:expire both orders when STP triggers; default NONE                                                                                                 |
     * | goodTillDate            | LONG    | NO        | order cancel time for timeInForce GTD, mandatory when timeInforce set to GTD; order the timestamp only retains second-level precision, ms part will be ignored; The goodTillDate timestamp must be greater than the current time plus 600 seconds and smaller than 253402300799000 |
     * | recvWindow              | LONG    | NO        |                                                                                                                                                                                                                                                                                    |
     * | timestamp               | LONG    | YES       |                                                                                                                                                                                                                                                                                    |     * Type
     * -------------------------------------------------------------------
     * | Type                           | Additional mandatory parameters |
     * |--------------------------------|---------------------------------|
     * | LIMIT                          | timeInForce, quantity, price    |
     * | MARKET                         | quantity                        |
     * | STOP/TAKE_PROFIT               | quantity, price, stopPrice      |
     * | STOP_MARKET/TAKE_PROFIT_MARKET | stopPrice                       |
     * | TRAILING_STOP_MARKET           | callbackRate                    |
     */
    public LinkedHashMap<String, Object> defaultMarketOrder(String clientId) {
        LinkedHashMap<String, Object> params = new LinkedHashMap<>();
        params.put("positionSide", "BOTH");
        params.put("type", "MARKET");
        params.put("newClientOrderId", clientId);
        params.put("newOrderRespType", "RESULT");

        return params;
    }

    public LinkedHashMap<String, Object> defaultLimitOrder(String clientId) {
        LinkedHashMap<String, Object> params = new LinkedHashMap<>();
        params.put("positionSide", "BOTH");
        params.put("type", "LIMIT");
        params.put("newClientOrderId", clientId);
        params.put("newOrderRespType", "RESULT");

        return params;
    }

    public LinkedHashMap<String, Object> defaultReduceOnlyOrder(String clientId) {
        LinkedHashMap<String, Object> params = defaultMarketOrder(clientId);
        params.put("reduceOnly", "true");
        return params;
    }

    public Map<String, Object> placeMarketBuyOrder(String symbol, String quantity,
                                                   boolean isTestOrder,String clientId) throws Exception {
        LinkedHashMap<String, Object> params = defaultMarketOrder(clientId);
        params.put("symbol", symbol);
        params.put("side", "BUY");
        params.put("quantity", quantity);
        String jsonRs = "{}";
        if (isTestOrder) {
            jsonRs = client.account().newTestOrder(params);
        } else {
            jsonRs = client.account().newOrder(params);
        }
        return new ObjectMapper().readValue(jsonRs, new TypeReference<>() {
        });
    }

    public Map<String, Object> placeLimitBuyOrder(String symbol, String quantity, String price,
                                                  boolean isTestOrder,String clientId) throws Exception {
        LinkedHashMap<String, Object> params = defaultLimitOrder(clientId);
        params.put("symbol", symbol);
        params.put("side", "BUY");
        params.put("quantity", quantity);
        params.put("price", price);
        params.put("type", "LIMIT");
        params.put("timeInForce", "GTC");
        String jsonRs = "{}";
        if (isTestOrder) {
            jsonRs = client.account().newTestOrder(params);
        } else {
            jsonRs = client.account().newOrder(params);
        }
        return new ObjectMapper().readValue(jsonRs, new TypeReference<>() {
        });
    }

    public Map<String, Object> placeLimitSellOrder(String symbol, String quantity, String price,
                                                   boolean isTestOrder,String clientId) throws Exception {
        LinkedHashMap<String, Object> params = defaultLimitOrder(clientId);
        params.put("symbol", symbol);
        params.put("side", "SELL");
        params.put("quantity", quantity);
        params.put("price", price);
        params.put("type", "LIMIT");
        params.put("timeInForce", "GTC");
        String jsonRs = "{}";
        if (isTestOrder) {
            jsonRs = client.account().newTestOrder(params);
        } else {
            jsonRs = client.account().newOrder(params);
        }
        return new ObjectMapper().readValue(jsonRs, new TypeReference<>() {
        });
    }

    public Map<String, Object> placeMarketSellOrder(String symbol, String quantity,
                                                    boolean isTestOrder,String clientId) throws Exception {
        LinkedHashMap<String, Object> params = defaultMarketOrder(clientId);
        params.put("symbol", symbol);
        params.put("side", "SELL");
        params.put("quantity", quantity);
        String jsonRs = "{}";
        if (isTestOrder) {
            jsonRs = client.account().newTestOrder(params);
        } else {
            jsonRs = client.account().newOrder(params);
        }
        return new ObjectMapper().readValue(jsonRs, new TypeReference<>() {
        });
    }

    public Map<String, Object> placeBuyTakeProfitOrder(String symbol, String quantity, String price,
                                                       boolean isTestOrder,String clientId) throws Exception {
        LinkedHashMap<String, Object> params = defaultReduceOnlyOrder(clientId);
        params.put("type", "TAKE_PROFIT_MARKET");
        params.put("symbol", symbol);
        params.put("side", "BUY");
        params.put("quantity", quantity);
        params.put("stopPrice", price);
        String jsonRs = "{}";
        if (isTestOrder) {
            jsonRs = client.account().newTestOrder(params);
        } else {
            jsonRs = client.account().newOrder(params);
        }
        return new ObjectMapper().readValue(jsonRs, new TypeReference<>() {
        });
    }

    public Map<String, Object> placeBuyTakeStopLossOrder(String symbol, String quantity, String price,
                                                         boolean isTestOrder,String clientId) throws Exception {
        LinkedHashMap<String, Object> params = defaultReduceOnlyOrder(clientId);
        params.put("type", "STOP_MARKET");
        params.put("symbol", symbol);
        params.put("side", "BUY");
        params.put("quantity", quantity);
        params.put("stopPrice", price);
        String jsonRs = "{}";
        if (isTestOrder) {
            jsonRs = client.account().newTestOrder(params);
        } else {
            jsonRs = client.account().newOrder(params);
        }
        return new ObjectMapper().readValue(jsonRs, new TypeReference<>() {
        });
    }

    public Map<String, Object> placeSellTakeProfitOrder(String symbol, String quantity, String price,
                                                        boolean isTestOrder,String clientId) throws Exception {
        LinkedHashMap<String, Object> params = defaultReduceOnlyOrder(clientId);
        params.put("type", "TAKE_PROFIT_MARKET");
        params.put("symbol", symbol);
        params.put("side", "SELL");
        params.put("quantity", quantity);
        params.put("stopPrice", price);
        String jsonRs = "{}";
        if (isTestOrder) {
            jsonRs = client.account().newTestOrder(params);
        } else {
            jsonRs = client.account().newOrder(params);
        }
        return new ObjectMapper().readValue(jsonRs, new TypeReference<>() {
        });
    }

    public Map<String, Object> placeSellTakeStopLossOrder(String symbol, String quantity, String price,
                                                          boolean isTestOrder,String clientId) throws Exception {
        LinkedHashMap<String, Object> params = defaultReduceOnlyOrder(clientId);
        params.put("type", "STOP_MARKET");
        params.put("symbol", symbol);
        params.put("side", "SELL");
        params.put("quantity", quantity);
        params.put("stopPrice", price);
        String jsonRs = "{}";
        if (isTestOrder) {
            jsonRs = client.account().newTestOrder(params);
        } else {
            jsonRs = client.account().newOrder(params);
        }
        return new ObjectMapper().readValue(jsonRs, new TypeReference<>() {
        });
    }

    public String cancelAllOpenOrders(String symbol) {
        LinkedHashMap<String, Object> params = new LinkedHashMap<>();
        params.put("symbol", symbol);
        return client.account().cancelAllOpenOrders(params);
    }

    public Map<String,Object> cancelOrder(String symbol,String orderId) throws Exception {
        LinkedHashMap<String, Object> params = new LinkedHashMap<>();
        params.put("symbol", symbol);
        params.put("orderId", orderId);
        return  new ObjectMapper().readValue(client.account().cancelOrder(params),new TypeReference<>() {
        });
    }

    public static String durationToString(int duration) {
        return switch (duration) {
            case 1 -> "1m";
            case 3 -> "3m";
            case 5 -> "5m";
            case 15 -> "15m";
            case 30 -> "30m";
            case 60 -> "1h";
            case 120 -> "2h";
            case 180 -> "3h";
            case 240 -> "4h";
            case 360 -> "6h";
            case 480 -> "8h";
            case 720 -> "12h";
            case 1440 -> "1d";
            case 1440 * 3 -> "3d";
            case 1440 * 7 -> "1w";
            case 1440 * 30 -> "1mo";
            default -> "5m";
        };
    }

    public static Duration fromString(String interval) {
        return switch (interval) {
            case "1m" -> Duration.ofMinutes(1);
            case "3m" -> Duration.ofMinutes(3);
            case "5m" -> Duration.ofMinutes(5);
            case "15m" -> Duration.ofMinutes(15);
            case "30m" -> Duration.ofMinutes(30);
            case "1h" -> Duration.ofHours(1);
            case "2h" -> Duration.ofHours(2);
            case "3h" -> Duration.ofHours(3);
            case "4h" -> Duration.ofHours(4);
            case "6h" -> Duration.ofHours(6);
            case "8h" -> Duration.ofHours(8);
            case "12h" -> Duration.ofHours(12);
            case "1d" -> Duration.ofHours(24);
            case "3d" -> Duration.ofDays(3);
            case "1w" -> Duration.ofDays(7);
            case "1mo" -> Duration.ofDays(30);
            default -> Duration.ofMinutes(5);
        };
    }

    /*
        [
            [
                1499040000000,      // Open time
                "0.01634790",       // Open
                "0.80000000",       // High
                "0.01575800",       // Low
                "0.01577100",       // Close
                "148976.11427815",  // Volume
                1499644799999,      // Close time
                "2434.19055334",    // Quote asset volume
                308,                // Number of trades
                "1756.87402397",    // Taker buy base asset volume
                "28.46694368",      // Taker buy quote asset volume
                "17928899.62484339" // Ignore.
            ]
        ]
         */
    public List<Candle> getRecentCandle(String symbol, String interval,
                                        int limit) throws JsonProcessingException {
        if (limit < 0)
            return List.of();
        int fetchSize = Math.min(limit, MAX_SIZE);
        var param = new LinkedHashMap<String, Object>();
        ObjectMapper objectMapper = new ObjectMapper();
        param.put("symbol", symbol);
        param.put("interval", interval);
        param.put("limit", fetchSize);
        String result = client.market().klines(param);
        List<List<Object>> rawKlines = objectMapper.readValue(result, new TypeReference<>() {
        });

        List<Candle> candles = rawKlines.stream().map(kline -> Candle.newBuilder()
                .setStartTime(((Number) kline.get(0)).longValue())
                .setOpen(Double.parseDouble((String) kline.get(1)))
                .setHigh(Double.parseDouble((String) kline.get(2)))
                .setLow(Double.parseDouble((String) kline.get(3)))
                .setClose(Double.parseDouble((String) kline.get(4)))
                .setVolume(Double.parseDouble((String) kline.get(5)))
                .setEndTime(((Number) kline.get(6)).longValue())
                .setDuration(fromString(interval).toMinutes())
                .build()).toList();
        List<Candle> res = new ArrayList<>();
        res.addAll(candles);
        res.addAll(getRecentCandle(symbol, interval, limit - MAX_SIZE));
        return res;
    }


    /* Example json response
     * {
     *     "avgPrice": "0.00000",
     *     "clientOrderId": "abc",
     *     "cumQuote": "0",
     *     "executedQty": "0",
     *     "orderId": 1917641,
     *     "origQty": "0.40",
     *     "origType": "TRAILING_STOP_MARKET",
     *     "price": "0",
     *     "reduceOnly": false,
     *     "side": "BUY",
     *     "positionSide": "SHORT",
     *     "status": "NEW",
     *     "stopPrice": "9300",                // please ignore when order type is TRAILING_STOP_MARKET
     *     "closePosition": false,   // if Close-All
     *     "symbol": "BTCUSDT",
     *     "time": 1579276756075,              // order time
     *     "timeInForce": "GTC",
     *     "type": "TRAILING_STOP_MARKET",
     *     "activatePrice": "9020",            // activation price, only return with TRAILING_STOP_MARKET order
     *     "priceRate": "0.3",                 // callback rate, only return with TRAILING_STOP_MARKET order
     *     "updateTime": 1579276756075,        // update time
     *     "workingType": "CONTRACT_PRICE",
     *     "priceProtect": false,            // if conditional order trigger is protected
     *     "priceMatch": "NONE",              //price match mode
     *     "selfTradePreventionMode": "NONE", //self trading preventation mode
     *     "goodTillDate": 0                  //order pre-set auot cancel time for TIF GTD order
     * }
     */
    public Map<String, Object> getOrderStatus(String symbol, String orderId) throws JsonProcessingException {
        LinkedHashMap<String, Object> params = new LinkedHashMap<>();
        params.put("symbol", symbol);
        params.put("origClientOrderId", orderId);
        // hint : from example json response use ObjectMapper extract status value
        String jsonStr = client.account().queryOrder(params);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(jsonStr, new TypeReference<>() {
        });
    }



    public void subscribeCandleEvent(Map<String,List<Integer>> symbolIntervalsMap, Consumer<String> onMessage,
                                     Consumer<String> onError, Consumer<String> onOpen, Consumer<String> onClosing) {
        // Hint: streams string from by symbol@kline_@interval
        // e.g. btcusdt@kline_1m
        // create list streams from symbol and durations
        ArrayList<String> streams = new ArrayList<>();
        for (Map.Entry<String, List<Integer>> entry : symbolIntervalsMap.entrySet()) {
            String symbol = entry.getKey();
            List<Integer> durations = entry.getValue();
            for (int duration : durations) {
                streams.add(symbol.toLowerCase() + "@kline_" + durationToString(duration));
            }
        }
        wsClient.combineStreams(streams, onOpen::accept, onMessage::accept, onClosing::accept, onError::accept);
    }

    /**
     * {
     * "e": "kline",     // Event type
     * "E": 1638747660000,   // Event time
     * "s": "BTCUSDT",    // Symbol
     * "k": {
     * "t": 1638747660000, // Kline start time
     * "T": 1638747719999, // Kline close time
     * "s": "BTCUSDT",  // Symbol
     * "i": "1m",      // Interval
     * "f": 100,       // First trade ID
     * "L": 200,       // Last trade ID
     * "o": "0.0010",  // Open price
     * "c": "0.0020",  // Close price
     * "h": "0.0025",  // High price
     * "l": "0.0015",  // Low price
     * "v": "1000",    // Base asset volume
     * "n": 100,       // Number of trades
     * "x": false,     // Is this kline closed?
     * "q": "1.0000",  // Quote asset volume
     * "V": "500",     // Taker buy base asset volume
     * "Q": "0.500",   // Taker buy quote asset volume
     * "B": "123456"   // Ignore
     * }
     * }
     *
     * @param eventStr
     * @return
     */

    public static Candle fromCandleStickEvent(String eventStr) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Object> root = objectMapper.readValue(eventStr, new TypeReference<>() {
            });
            LinkedHashMap<String, Object> data = (LinkedHashMap<String, Object>) root.get("data");
            LinkedHashMap<String, Object> kline = (LinkedHashMap<String, Object>) data.get("k");
            return Candle.newBuilder().setStartTime(((Number) kline.get("t")).longValue())
                    .setSymbol((String) kline.get("s"))
                    .setOpen(Double.parseDouble((String) kline.get("o")))
                    .setHigh(Double.parseDouble((String) kline.get("h")))
                    .setLow(Double.parseDouble((String) kline.get("l")))
                    .setClose(Double.parseDouble((String) kline.get("c")))
                    .setVolume(Double.parseDouble((String) kline.get("v")))
                    .setEndTime(((Number) kline.get("T")).longValue())
                    .setDuration(fromString((String) kline.get("i")).toMinutes())
                    .setIsCloseCandle((Boolean) kline.get("x")).build();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

}
