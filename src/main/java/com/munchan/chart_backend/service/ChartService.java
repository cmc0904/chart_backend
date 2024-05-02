package com.munchan.chart_backend.service;

import com.munchan.chart_backend.exception.NotExistDeviceException;
import com.munchan.chart_backend.vo.chart.AllCharts;
import com.munchan.chart_backend.vo.chart.ChartData;

import java.util.List;

public interface ChartService {

    // 차트 정보 불러오기
    AllCharts getCharts();

    // 차트 정보 불러오기
    AllCharts getSearchedCharts(String deviceName, String startDate, String endDate) throws NotExistDeviceException;

    // 디바이스 이름 -> 디바이스 아이디
    Integer getDeviceIdByDeviceName(String deviceName) throws NotExistDeviceException;

    // 모든 기기 이름 불러오기
    List<String> getAllDeviceName(String deviceName);

    // 모든 장비중 장애가 가장 많이 일어난 장비
    ChartData getMaxErrorDevice();
}
