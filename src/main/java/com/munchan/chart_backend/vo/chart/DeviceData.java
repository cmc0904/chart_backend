package com.munchan.chart_backend.vo.chart;

public class DeviceData {
    private final Integer deviceId;
    private final String deviceName;
    private final int averageMemoryUsage;
    private final int averageCPUUsage;
    private final int averageTemperature;

    public DeviceData(Integer deviceId, String deviceName, int averageMemoryUsage, int averageCPUUsage, int averageTemperature) {
        this.deviceId = deviceId;
        this.deviceName = deviceName;
        this.averageMemoryUsage = averageMemoryUsage;
        this.averageCPUUsage = averageCPUUsage;
        this.averageTemperature = averageTemperature;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public int getAverageTemperature() {
        return averageTemperature;
    }

    public int getAverageCPUUsage() {
        return averageCPUUsage;
    }

    public int getAverageMemoryUsage() {
        return averageMemoryUsage;
    }
}
