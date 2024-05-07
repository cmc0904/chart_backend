package com.munchan.chart_backend.service;

import com.munchan.chart_backend.exception.NotExistDeviceException;
import com.munchan.chart_backend.repository.ChartRepository;
import com.munchan.chart_backend.vo.chart.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class ChatServiceImpl implements ChartService {
    private final ChartRepository chartRepository;

    @Autowired
    public ChatServiceImpl(ChartRepository chartRepository) {
        this.chartRepository = chartRepository;
    }

    @Override
    public AllCharts getChart(String startDate, String endDate) {
        return new AllCharts(
                new Chart(chartRepository.getDeviceCPUChartData(null, startDate, endDate))
                , new Chart(chartRepository.getModelDisorderChartData(null, startDate, endDate))
                , new Chart(chartRepository.getDisorderTypeChartData(null, startDate, endDate))
                , new Chart(chartRepository.getDailyDisorderChartData(null, startDate, endDate))
        );
    }

    @Override
    public AllCharts getChart(String deviceName, String startDate, String endDate) throws NotExistDeviceException {
        Integer deviceNameToDeviceId = getDeviceIdByDeviceName(deviceName);

        return new AllCharts(
            chartRepository.getDeviceInformation(deviceNameToDeviceId)
            , new Chart(chartRepository.getDeviceCPUChartData(deviceNameToDeviceId, startDate, endDate))
            , new Chart(chartRepository.getModelDisorderChartData(deviceNameToDeviceId, startDate, endDate))
            , new Chart(chartRepository.getDisorderTypeChartData(deviceNameToDeviceId, startDate, endDate))
            , new Chart(chartRepository.getDailyDisorderChartData(deviceNameToDeviceId, startDate, endDate))
        );
    }

    @Override
    public Integer getDeviceIdByDeviceName(String deviceName) throws NotExistDeviceException {
        Optional<Integer> foundDeviceId = chartRepository.getDeviceIdByDeviceName(deviceName);

        if (foundDeviceId.isPresent()) {
            return foundDeviceId.get();
        } else {
            throw new NotExistDeviceException();
        }
    }

    @Override
    public List<String> getAllDeviceName(String deviceName) {
        return chartRepository.getAllDeviceName(deviceName);
    }

    @Override
    public ChartData getMaxErrorDevice() {
        return chartRepository.getMaxErrorDeviceName();
    }
}
