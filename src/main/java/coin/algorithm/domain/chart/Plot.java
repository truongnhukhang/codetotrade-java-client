package coin.algorithm.domain.chart;

import org.ta4j.core.Indicator;
import org.ta4j.core.num.Num;

import java.util.List;

public class Plot {

    public Plot(String name) {
        this.name = name;
    }
    String name;
    String color = "#000000";
    Indicator<Num> indicator;
    List<Float> indicatorValues;
    int pricePrecision;
    PlotStyle style = PlotStyle.LINE;


    public Plot withColor(String color) {
        this.color = color;
        return this;
    }
    public Plot withIndicator(Indicator<Num> indicator) {
        this.indicator = indicator;
        return this;
    }

    public Plot withPricePrecision(int pricePrecision) {
        this.pricePrecision = pricePrecision;
        return this;
    }

    public Plot withStyle(PlotStyle style) {
        this.style = style;
        return this;
    }

    public Plot withIndicatorValues(List<Float> indicatorValues) {
        this.indicatorValues = indicatorValues;
        return this;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Indicator<Num> getIndicator() {
        return indicator;
    }

    public void setIndicator(Indicator<Num> indicator) {
        this.indicator = indicator;
    }

    public int getPricePrecision() {
        return pricePrecision;
    }

    public void setPricePrecision(int pricePrecision) {
        this.pricePrecision = pricePrecision;
    }

    public PlotStyle getStyle() {
        return style;
    }

    public void setStyle(PlotStyle style) {
        this.style = style;
    }

    public List<Float> getIndicatorValues() {
        return indicatorValues;
    }

    public void setIndicatorValues(List<Float> indicatorValues) {
        this.indicatorValues = indicatorValues;
    }
}
