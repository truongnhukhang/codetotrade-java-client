package coin.algorithm.domain.chart;

public enum PlotStyle {
    LINE(0), COLUMN(1);

    int value;

    PlotStyle(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static PlotStyle fromValue(int value) {
        for (PlotStyle plotStyle : PlotStyle.values()) {
            if (plotStyle.getValue() == value) {
                return plotStyle;
            }
        }
        return null;
    }
}
