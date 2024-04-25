package com.munchan.chart_backend.service;

import com.munchan.chart_backend.exception.NotExistDeviceException;
import com.munchan.chart_backend.vo.chart.AllCharts;

public interface ChartService {
    AllCharts getCharts(String deviceName) throws NotExistDeviceException;

    AllCharts getCharts(String deviceName, String startDate, String endDate) throws NotExistDeviceException;

    Integer getDeviceIdByDeviceName(String deviceName) throws NotExistDeviceException;
}
