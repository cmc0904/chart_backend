package com.munchan.chart_backend.vo.chart;

import java.util.List;

public class AllCharts {

    private final DeviceData deviceData;
    private final Chart deviceCPU;
    private final Chart modelDisorder;
    private final Chart disorderType;
    private final Chart dailyDisorder;

    public AllCharts(DeviceData deviceData, Chart deviceCPU, Chart modelDisorder, Chart disorderType, Chart dailyDisorder) {
        this.deviceData = deviceData;
        this.deviceCPU = deviceCPU;
        this.modelDisorder = modelDisorder;
        this.disorderType = disorderType;
        this.dailyDisorder = dailyDisorder;
    }

    public AllCharts(Chart deviceCPU, Chart modelDisorder, Chart disorderType, Chart dailyDisorder) {
        this.deviceData = null;
        this.deviceCPU = deviceCPU;
        this.modelDisorder = modelDisorder;
        this.disorderType = disorderType;
        this.dailyDisorder = dailyDisorder;
    }

    public DeviceData getDeviceData() {
        return deviceData;
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

    @Override
    public String toString() {
        return "AllCharts{" +
                "deviceCPU=" + deviceCPU +
                ", modelDisorder=" + modelDisorder +
                ", disorderType=" + disorderType +
                ", dailyDisorder=" + dailyDisorder +
                '}';
    }
}
