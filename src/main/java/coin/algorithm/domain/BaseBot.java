package coin.algorithm.domain;

import coin.algorithm.domain.chart.Chart;
import org.ta4j.core.Bar;
import org.ta4j.core.BarSeries;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class BaseBot implements BotController {
    protected BarSeries barSeries;
    protected Map<Duration, BarSeries> btcDomBarSeries = new HashMap<>();
    protected Map<Duration, BarSeries> otherBarSeries = new HashMap<>();
    protected CoinInfo coinInfo;
    protected BotConfig botConfig;
    protected List<Chart> chartList = new ArrayList<>();

    public static int getIndexOfBarSeriesByTime(BarSeries barSeries, long time) {
        List<Bar> bars = barSeries.getBarData();
        // find first index that time >= beginTime and time <= endTime
        int i = 0;
        long beginTime = bars.getFirst().getBeginTime().toInstant().toEpochMilli();
        long endTime = bars.getFirst().getEndTime().toInstant().toEpochMilli();
        if (time >= beginTime && time <= endTime) {
            return i;
        }
        // find end index that time >= beginTime and time <= endTime
        i = bars.size() - 1;
        beginTime = bars.getLast().getBeginTime().toInstant().toEpochMilli();
        endTime = bars.getLast().getEndTime().toInstant().toEpochMilli();
        if (time >= beginTime && time <= endTime) {
            return i;
        }
        // find by BinarySearch
        return findIndexByBinarySearch(bars, time);
    }

    private static int findIndexByBinarySearch(List<Bar> bars, long time) {
        int low = 0;
        int hi = bars.size() - 1;
        while (low <= hi) {
            int mid = low + (hi - low) / 2;
            long beginTime = bars.get(mid).getBeginTime().toInstant().toEpochMilli();
            long endTime = bars.get(mid).getEndTime().toInstant().toEpochMilli();
            if (time >= beginTime && time <= endTime) {
                return mid;
            }
            if (time < beginTime) {
                hi = mid - 1;
            }
            if (time > endTime) {
                low = mid + 1;
            }
        }
        return -1;

    }

    public TimeTravel timeTravel() {
        TimeTravel timeTravel = new TimeTravel();
        List<Integer> buysell = new ArrayList<>(this.barSeries.getBarCount());
        List<TradeMetadata> metadata = new ArrayList<>(this.barSeries.getBarCount());
        for (int i = this.barSeries.getBeginIndex(); i <= this.barSeries.getEndIndex(); i++) {
            if (isBuy(i)) {
                buysell.add(1);
                metadata.add(buy(i));
            }
            if (isSell(i)) {
                buysell.add(2);
                metadata.add(sell(i));
            }
            if(botConfig.isEnableCloseMode() && isCloseCurrentPosition(i)) {
                buysell.add(3);
                metadata.add(new TradeMetadata());
            }
            if (!isBuy(i) && !isSell(i)) {
                buysell.add(0);
                metadata.add(new TradeMetadata());
            }
        }
        timeTravel.setBuySell(buysell);
        timeTravel.setMetadata(metadata);
        return timeTravel;
    }

    public void setBotConfig(BotConfig botConfig) {
        this.botConfig = botConfig;
    }

    public BaseBot() {
    }

    public void setCoinInfo(CoinInfo coinInfo) {
        this.coinInfo = coinInfo;
    }

    public Map<Duration, BarSeries> getBtcDomBarSeries() {
        return btcDomBarSeries;
    }

    public void setBtcDomBarSeries(Map<Duration, BarSeries> btcDomBarSeries) {
        this.btcDomBarSeries = btcDomBarSeries;
    }

    public List<Chart> getChartList() {
        return chartList;
    }

    public void setChartList(List<Chart> chartList) {
        this.chartList = chartList;
    }

    public BarSeries getBarSeries() {
        return barSeries;
    }

    public void setBarSeries(BarSeries barSeries) {
        this.barSeries = barSeries;
    }

    public Map<Duration, BarSeries> getOtherBarSeries() {
        return otherBarSeries;
    }

    public void setOtherBarSeries(Map<Duration, BarSeries> otherBarSeries) {
        this.otherBarSeries = otherBarSeries;
    }

    public CoinInfo getCoinInfo() {
        return coinInfo;
    }

    public BotConfig getBotConfig() {
        return botConfig;
    }
}
