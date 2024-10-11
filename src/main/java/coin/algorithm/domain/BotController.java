package coin.algorithm.domain;

import java.util.Map;

public interface BotController {
    void init(Map<String,String> params);

    boolean isBuy(int index);

    boolean isSell(int index);

    default boolean isCloseCurrentPosition(int index) {
        return false;
    }

    TradeMetadata buy(int index);

    TradeMetadata sell( int index);

}
