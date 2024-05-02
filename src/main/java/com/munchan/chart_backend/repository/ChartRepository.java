package com.munchan.chart_backend.repository;

import com.munchan.chart_backend.vo.chart.ChartData;
import com.munchan.chart_backend.vo.chart.DeviceData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ChartRepository {
    // 장비별 CPU 탑 10
    List<ChartData> getDeviceCPUChartData(Integer deviceId, String startDay, String endDay);
    // 모델별 장애 탑 10
    List<ChartData> getModelDisorderChartData(Integer deviceId, String startDay, String endDay);
    // 장애 종류별 탑 10
    List<ChartData> getDisorderTypeChartData(Integer deviceId, String startDay, String endDay);
    // 일별 장애 추이
    List<ChartData> getDailyDisorderChartData(Integer deviceId, String startDay, String endDay);
    // 장비 이름 -> 장비 ID
    Optional<Integer> getDeviceIdByDeviceName(String deviceName);

    // 모든 장비 이름 불러오기
    List<String> getAllDeviceName(String deviceName);

    // 장비중 장애가 가장 많이 일어난 장비 불러오기
    ChartData getMaxErrorDeviceName();

    // 디바이스 이름, 디바이스 아이디, CPU 평균 사용량, 평균 온도, 평균 메모리 사용량
    DeviceData getDeviceInformation(Integer deviceId);
}
