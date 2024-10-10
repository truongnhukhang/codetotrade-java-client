package coin.algorithm.grpc.server;

import coin.algorithm.domain.BackTestData;
import coin.algorithm.domain.BaseBot;
import coin.algorithm.grpc.service.Chart;
import coin.algorithm.grpc.service.Plot;
import coin.algorithm.grpc.service.PlotStyle;
import coin.algorithm.grpc.service.TradeMetadata;
import org.ta4j.core.Bar;
import org.ta4j.core.BarSeries;
import org.ta4j.core.Indicator;
import org.ta4j.core.num.Num;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProtoConverter {
    public static TradeMetadata toProtoTradeMetadata(coin.algorithm.domain.TradeMetadata tm) {
        return TradeMetadata.newBuilder().setAmount(tm.getAmount()).setPrice(tm.getPrice())
                .setTakeProfitPrice(tm.getTakeProfitPrice()).setTakeStopLossPrice(tm.getTakeStopLossPrice())
                .setTradeLog(tm.getTradeLog()).build();
    }


    public static Chart toProtoChart(coin.algorithm.domain.chart.Chart c, BackTestData backTestData) {
        return Chart.newBuilder().setName(c.getName()).setBackgroundColor(c.getBackgroundColor())
                .setHeight(c.getHeight()).setWidth(c.getWidth()).setIsOverlay(c.isOverlay())
                .addAllPlotList(c.getPlotList().stream()
                        .map(p -> Plot.newBuilder().setColor(p.getColor()).setName(p.getName())
                                .setStyle(PlotStyle.forNumber(p.getStyle().getValue()))
                                .setPricePrecision(p.getPricePrecision())
                                .addAllValueList(getIndicatorValues(p.getIndicator(), backTestData))
                                .build()).collect(Collectors.toList())).build();
    }

    private static List<Float> getIndicatorValues(Indicator<Num> indicator, BackTestData backTestData) {
        Duration durationIndicator = indicator.getBarSeries().getFirstBar().getTimePeriod();
        Duration durationMain = backTestData.getBarSeries().getFirstBar().getTimePeriod();
        if (durationIndicator.toMinutes() == durationMain.toMinutes()) {
            int barCount = indicator.getBarSeries().getBarCount();
            List<Float> all = new ArrayList<>(barCount);
            int startIndex = Math.max(0, -barCount + 1);
            for (int i = 0; i < barCount; i++) {
                Num number = indicator.getValue(i + startIndex);
                all.add(((Double) number.doubleValue()).floatValue());
            }
            return all;
        } else {
            List<Float> values = new ArrayList<>();
            BarSeries indicatorBarSeries = indicator.getBarSeries();
            BarSeries mainBarSeries = backTestData.getBarSeries();
            List<Bar> barData = mainBarSeries.getBarData();
            for (int i = 0; i < barData.size() - 1; i++) {
                long closeTime = barData.get(i).getEndTime().toInstant().toEpochMilli();
                int idx = BaseBot.getIndexOfBarSeriesByTime(indicatorBarSeries, closeTime);
                values.add(indicator.getValue(idx).floatValue());
            }
            return values;
        }
    }
}
