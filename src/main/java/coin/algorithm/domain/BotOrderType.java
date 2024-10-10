package coin.algorithm.domain;

public enum BotOrderType {
    MARKET(0), LIMIT_ORDER(1);
    public final int i;

    BotOrderType(int i) {
        this.i = i;
    }

    public int getValue() {
        return i;
    }
}
