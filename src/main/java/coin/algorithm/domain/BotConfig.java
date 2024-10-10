package coin.algorithm.domain;

public class BotConfig {
    int botOrderType; // 0 -> MARKET, 1 -> LIMIT_ORDER
    boolean isEnableCloseMode;
    int initBar;
    double initBalance;
    double makerFee;
    double takerFee;

    public BotConfig() {
    }

    public BotConfig(int botOrderType, boolean isEnableCloseMode, int initBar, double initBalance,
                     double makerFee, double takerFee) {
        this.botOrderType = botOrderType;
        this.isEnableCloseMode = isEnableCloseMode;
        this.initBar = initBar;
        this.initBalance = initBalance;
        this.makerFee = makerFee;
        this.takerFee = takerFee;
    }

    public int getBotOrderType() {
        return botOrderType;
    }

    public void setBotOrderType(int botOrderType) {
        this.botOrderType = botOrderType;
    }

    public boolean isEnableCloseMode() {
        return isEnableCloseMode;
    }

    public void setEnableCloseMode(boolean enableCloseMode) {
        isEnableCloseMode = enableCloseMode;
    }

    public int getInitBar() {
        return initBar;
    }

    public void setInitBar(int initBar) {
        this.initBar = initBar;
    }

    public double getInitBalance() {
        return initBalance;
    }

    public void setInitBalance(double initBalance) {
        this.initBalance = initBalance;
    }

    public double getMakerFee() {
        return makerFee;
    }

    public void setMakerFee(double makerFee) {
        this.makerFee = makerFee;
    }

    public double getTakerFee() {
        return takerFee;
    }

    public void setTakerFee(double takerFee) {
        this.takerFee = takerFee;
    }
}
