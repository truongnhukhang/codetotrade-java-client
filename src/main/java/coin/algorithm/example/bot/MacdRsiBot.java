package coin.algorithm.example.bot;

import coin.algorithm.domain.BaseBot;
import coin.algorithm.domain.TradeMetadata;
import org.ta4j.core.indicators.EMAIndicator;
import org.ta4j.core.indicators.MACDIndicator;
import org.ta4j.core.indicators.RSIIndicator;
import org.ta4j.core.indicators.helpers.ClosePriceIndicator;

import java.util.Map;

public class MacdRsiBot extends BaseBot {
    RSIIndicator rsiIndicator;
    MACDIndicator macdIndicator;
    EMAIndicator macdSignalIndicator;

    @Override
    public void init(Map<String, String> params) {
        //hint : extract parameters from params (rsi,macd_long,macd_short,macd_signal)
        var rsi = Integer.parseInt(params.get("rsi"));
        var macdLong = Integer.parseInt(params.get("macd_long"));
        var macdShort = Integer.parseInt(params.get("macd_short"));
        var macdSignal = Integer.parseInt(params.get("macd_signal"));
        rsiIndicator = new RSIIndicator(new ClosePriceIndicator(barSeries), rsi);
        macdIndicator = new MACDIndicator(new ClosePriceIndicator(barSeries), macdShort, macdLong);
        macdSignalIndicator = new EMAIndicator(macdIndicator, macdSignal);
    }

    @Override
    public boolean isBuy(int index) {
        return macdSignalIndicator.getValue(index).isLessThan(macdIndicator.getValue(index))
                && rsiIndicator.getValue(index).doubleValue() < 30;
    }

    @Override
    public boolean isSell(int index) {
        return macdSignalIndicator.getValue(index).isGreaterThan(macdIndicator.getValue(index))
                && rsiIndicator.getValue(index).doubleValue() < 70;
    }

    @Override
    public TradeMetadata buy(int index) {
        // log macd, macdSignal, rsi values
        String logs = String.format("macd: %.2f, macdSignal: %.2f, rsi: %.2f",
                macdIndicator.getValue(index).doubleValue(),
                macdSignalIndicator.getValue(index).doubleValue(),
                rsiIndicator.getValue(index).doubleValue());
        double price = barSeries.getBar(index).getClosePrice().doubleValue();
        // stoploss = 1% below the current price
        double stopLoss = price * 0.99;
        // take profit = 2% above the current price
        double takeProfit = price * 1.02;
        // the coin is btc/usdt . amount is number btc we buy or sell and it calculated based on the stop loss which guarantees maximum stop loss is 45$
        double amount = 45 / (price - stopLoss);
        return new TradeMetadata(price, amount, stopLoss, takeProfit, logs, 0);
    }

    @Override
    public TradeMetadata sell(int index) {
        // log macd, macdSignal, rsi values
        String logs = String.format("macd: %.2f, macdSignal: %.2f, rsi: %.2f",
                macdIndicator.getValue(index).doubleValue(),
                macdSignalIndicator.getValue(index).doubleValue(),
                rsiIndicator.getValue(index).doubleValue());
        double price = barSeries.getBar(index).getClosePrice().doubleValue();
        // stoploss = 1% above the current price
        double stopLoss = price * 1.01;
        // take profit = 2% below the current price
        double takeProfit = price * 0.98;
        // the coin is btc/usdt . amount is number btc we buy or sell and it calculated based on the stop loss which guarantees maximum stop loss is 45$
        double amount = 45 / (stopLoss - price);
        return new TradeMetadata(price, amount, stopLoss, takeProfit, logs, 0);
    }
}
