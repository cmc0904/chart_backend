package com.munchan.chart_backend.vo.chart;

import java.util.List;

public class Chart {
    private final List<ChartData> chartData;
    private final int min;
    private final int max;

    public Chart(List<ChartData> chartData) {
        this.chartData = chartData;

        if(chartData.isEmpty()) {
            min = 0;
            max = 0;
            return;
        };

        max = chartData.get(0).getValue();
        min = chartData.get(chartData.size() -1).getValue();
    }

    public List<ChartData> getChartData() {
        return chartData;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }
}
