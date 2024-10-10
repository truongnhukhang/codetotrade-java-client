package coin.algorithm.domain.chart;

import java.util.ArrayList;
import java.util.List;

public class Chart {
    boolean isOverlay;
    String name ;
    String backgroundColor = "#FFFFFF";
    int width;
    int height;
    List<Plot> plotList = new ArrayList<>();

    public Chart(String name) {
        this.name = name;
    }

    public Chart setOverlay(boolean overlay) {
        this.isOverlay = overlay;
        return this;
    }

    public Chart backgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
        return this;
    }

    public Chart width(int width) {
        this.width = width;
        return this;
    }

    public Chart height(int height) {
        this.height = height;
        return this;
    }
    public Chart withPlot(Plot plot) {
        this.plotList.add(plot);
        return this;
    }

    public boolean isOverlay() {
        return isOverlay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public List<Plot> getPlotList() {
        return plotList;
    }

    public void setPlotList(List<Plot> plotList) {
        this.plotList = plotList;
    }
}
