package coin.algorithm.domain;

public class TradeMetadata {
    double price;
    double amount;
    double takeProfitPrice;
    double takeStopLossPrice;
    String tradeLog = "";
    long waitingMinutes;
    String orderId = "";
    String takeProfitOrderId = "";
    String takeStopLossOrderId = "";
    public TradeMetadata() {
    }

    public TradeMetadata(double price, double amount, double takeProfitPrice, double takeStopLossPrice, String tradeLog,
                         long waitingMinutes) {
        this.price = price;
        this.amount = amount;
        this.takeProfitPrice = takeProfitPrice;
        this.takeStopLossPrice = takeStopLossPrice;
        this.tradeLog = tradeLog;
        this.waitingMinutes = waitingMinutes;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getTakeProfitOrderId() {
        return takeProfitOrderId;
    }

    public void setTakeProfitOrderId(String takeProfitOrderId) {
        this.takeProfitOrderId = takeProfitOrderId;
    }

    public String getTakeStopLossOrderId() {
        return takeStopLossOrderId;
    }

    public void setTakeStopLossOrderId(String takeStopLossOrderId) {
        this.takeStopLossOrderId = takeStopLossOrderId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getTakeProfitPrice() {
        return takeProfitPrice;
    }

    public void setTakeProfitPrice(double takeProfitPrice) {
        this.takeProfitPrice = takeProfitPrice;
    }

    public double getTakeStopLossPrice() {
        return takeStopLossPrice;
    }

    public void setTakeStopLossPrice(double takeStopLossPrice) {
        this.takeStopLossPrice = takeStopLossPrice;
    }

    public String getTradeLog() {
        return tradeLog;
    }

    public void setTradeLog(String tradeLog) {
        this.tradeLog = tradeLog;
    }

    public long getWaitingMinutes() {
        return waitingMinutes;
    }

    public void setWaitingMinutes(long waitingMinutes) {
        this.waitingMinutes = waitingMinutes;
    }
}
