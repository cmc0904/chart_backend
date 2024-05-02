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
    public AllCharts getCharts() {
        return new AllCharts(
                new Chart(chartRepository.getDeviceCPUChartData(null, null, null))
                , new Chart(chartRepository.getModelDisorderChartData(null, null, null))
                , new Chart(chartRepository.getDisorderTypeChartData(null, null, null))
                , new Chart(chartRepository.getDailyDisorderChartData(null, null, null))
        );
    }

    @Override
    public AllCharts getSearchedCharts(String deviceName, String startDate, String endDate) throws NotExistDeviceException {
        Integer deviceNameToDeviceId = getDeviceIdByDeviceName(deviceName);

        Long startDateTimeStamp = startDate != null ? Timestamp.valueOf(startDate).getTime() : null;
        Long endDateTimeStamp = endDate != null ? Timestamp.valueOf(endDate).getTime() : null;

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
