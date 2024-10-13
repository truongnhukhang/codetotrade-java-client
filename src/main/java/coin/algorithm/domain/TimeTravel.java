package coin.algorithm.domain;

import java.util.List;

public class TimeTravel {
    List<Signal> signals;
    List<TradeMetadata> metadata;

    public TimeTravel(List<Signal> signals, List<TradeMetadata> metadata) {
        this.signals = signals;
        this.metadata = metadata;
    }

    public TimeTravel() {

    }

    public List<Signal> getSignals() {
        return signals;
    }

    public void setSignals(List<Signal> signals) {
        this.signals = signals;
    }

    public List<TradeMetadata> getMetadata() {
        return metadata;
    }

    public void setMetadata(List<TradeMetadata> metadata) {
        this.metadata = metadata;
    }
}
