package com.munchan.chart_backend.vo.chart;

import java.util.List;

public class AllCharts {
    private final Chart deviceCPU;
    private final Chart modelDisorder;
    private final Chart disorderType;
    private final Chart dailyDisorder;

    public AllCharts(Chart deviceCPU, Chart modelDisorder, Chart disorderType, Chart dailyDisorder) {
        this.deviceCPU = deviceCPU;
        this.modelDisorder = modelDisorder;
        this.disorderType = disorderType;
        this.dailyDisorder = dailyDisorder;
    }

    public Chart getDeviceCPU() {
        return deviceCPU;
    }

    public Chart getModelDisorder() {
        return modelDisorder;
    }

    public Chart getDisorderType() {
        return disorderType;
    }

    public Chart getDailyDisorder() {
        return dailyDisorder;
    }
}
