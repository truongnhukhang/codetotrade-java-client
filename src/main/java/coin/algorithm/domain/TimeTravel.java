package coin.algorithm.domain;

import coin.algorithm.domain.TradeMetadata;

import java.util.List;

public class TimeTravel {
    List<Integer> buySell;
    List<TradeMetadata> metadata;

    public TimeTravel(List<Integer> buySell, List<TradeMetadata> metadata) {
        this.buySell = buySell;
        this.metadata = metadata;
    }

    public TimeTravel() {

    }

    public List<Integer> getBuySell() {
        return buySell;
    }

    public void setBuySell(List<Integer> buySell) {
        this.buySell = buySell;
    }

    public List<TradeMetadata> getMetadata() {
        return metadata;
    }

    public void setMetadata(List<TradeMetadata> metadata) {
        this.metadata = metadata;
    }
}
