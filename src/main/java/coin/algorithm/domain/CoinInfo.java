package coin.algorithm.domain;

public class CoinInfo {
    String symbol;
    int pricePrecision;
    int quantityPrecision;
    int tickSize;

    public CoinInfo() {
    }

    public CoinInfo(String symbol, int pricePrecision, int quantityPrecision, int tickSize) {
        this.symbol = symbol;
        this.pricePrecision = pricePrecision;
        this.quantityPrecision = quantityPrecision;
        this.tickSize = tickSize;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getPricePrecision() {
        return pricePrecision;
    }

    public void setPricePrecision(int pricePrecision) {
        this.pricePrecision = pricePrecision;
    }

    public int getQuantityPrecision() {
        return quantityPrecision;
    }

    public void setQuantityPrecision(int quantityPrecision) {
        this.quantityPrecision = quantityPrecision;
    }

    public int getTickSize() {
        return tickSize;
    }

    public void setTickSize(int tickSize) {
        this.tickSize = tickSize;
    }
}
