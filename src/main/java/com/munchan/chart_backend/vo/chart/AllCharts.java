package com.munchan.chart_backend.vo.chart;

import java.util.List;

public class AllCharts {
    private final List<ChartData> deviceCPU;
    private final List<ChartData> modelDisorder;
    private final List<ChartData> disorderType;
    private final List<ChartData> dailyDisorder;

    public AllCharts(List<ChartData> deviceCPU, List<ChartData> modelDisorder, List<ChartData> disorderType, List<ChartData> dailyDisorder) {
        this.deviceCPU = deviceCPU;
        this.modelDisorder = modelDisorder;
        this.disorderType = disorderType;
        this.dailyDisorder = dailyDisorder;
    }

    public List<ChartData> getDeviceCPU() {
        return deviceCPU;
    }

    public List<ChartData> getModelDisorder() {
        return modelDisorder;
    }

    public List<ChartData> getDisorderType() {
        return disorderType;
    }

    public List<ChartData> getDailyDisorder() {
        return dailyDisorder;
    }
}
