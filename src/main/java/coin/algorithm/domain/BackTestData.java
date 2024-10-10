package coin.algorithm.domain;

import coin.algorithm.grpc.service.Candle;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.ta4j.core.BarSeries;
import org.ta4j.core.BaseBar;
import org.ta4j.core.BaseBarSeries;

import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BackTestData {
    protected BarSeries barSeries;
    protected Map<Duration, BarSeries> btcDomBarSeries = new HashMap<>();
    protected Map<Duration, BarSeries> otherBarSeries = new HashMap<>();
    CoinInfo coinInfo;
    BotConfig botConfig;


    public BarSeries getBarSeries() {
        return barSeries;
    }

    public void setBarSeries(BarSeries barSeries) {
        this.barSeries = barSeries;
    }

    public Map<Duration, BarSeries> getBtcDomBarSeries() {
        return btcDomBarSeries;
    }

    public void setBtcDomBarSeries(Map<Duration, BarSeries> btcDomBarSeries) {
        this.btcDomBarSeries = btcDomBarSeries;
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

    public void setCoinInfo(CoinInfo coinInfo) {
        this.coinInfo = coinInfo;
    }

    public BotConfig getBotConfig() {
        return botConfig;
    }

    public void setBotConfig(BotConfig botConfig) {
        this.botConfig = botConfig;
    }

    public static BaseBarSeries fromCandles(List<Candle> candles) {
        return new BaseBarSeries(candles.stream().map(c -> new BaseBar(Duration.ofMinutes(c.getDuration()),
                                                                       ZonedDateTime.ofInstant(Instant.ofEpochMilli(c.getEndTime()),
                                                                                               ZoneId.of("UTC")),
                                                                       c.getOpen(),
                                                                       c.getHigh(),
                                                                       c.getLow(),
                                                                       c.getClose(),
                                                                       c.getVolume())).collect(Collectors.toList()));
    }
}
