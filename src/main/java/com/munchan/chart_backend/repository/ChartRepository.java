package com.munchan.chart_backend.repository;

import com.munchan.chart_backend.vo.chart.ChartData;
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
}
