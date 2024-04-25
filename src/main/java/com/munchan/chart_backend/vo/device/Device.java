package com.munchan.chart_backend.vo.device;

public class Device {
    private final Integer deviceId;
    private final String deviceName;

    public Device(Integer deviceId, String deviceName) {
        this.deviceId = deviceId;
        this.deviceName = deviceName;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public String getDeviceName() {
        return deviceName;
    }

}
