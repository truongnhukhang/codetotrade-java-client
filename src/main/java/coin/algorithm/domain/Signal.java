package coin.algorithm.domain;

public class Signal {
    long time;
    boolean isBuy;
    boolean isSell;
    boolean isCloseBuyPosition;
    boolean isCloseSellPosition;

    public Signal(long time, boolean isBuy, boolean isSell, boolean isCloseBuyPosition, boolean isCloseSellPosition) {
        this.time = time;
        this.isBuy = isBuy;
        this.isSell = isSell;
        this.isCloseBuyPosition = isCloseBuyPosition;
        this.isCloseSellPosition = isCloseSellPosition;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public boolean isBuy() {
        return isBuy;
    }

    public void setBuy(boolean buy) {
        isBuy = buy;
    }

    public boolean isSell() {
        return isSell;
    }

    public void setSell(boolean sell) {
        isSell = sell;
    }

    public boolean isCloseBuyPosition() {
        return isCloseBuyPosition;
    }

    public void setCloseBuyPosition(boolean closeBuyPosition) {
        isCloseBuyPosition = closeBuyPosition;
    }

    public boolean isCloseSellPosition() {
        return isCloseSellPosition;
    }

    public void setCloseSellPosition(boolean closeSellPosition) {
        isCloseSellPosition = closeSellPosition;
    }
}
