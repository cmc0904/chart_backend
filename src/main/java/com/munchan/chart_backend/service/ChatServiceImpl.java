package com.munchan.chart_backend.service;

import com.munchan.chart_backend.exception.NotExistDeviceException;
import com.munchan.chart_backend.repository.ChartRepository;
import com.munchan.chart_backend.vo.chart.AllCharts;
import com.munchan.chart_backend.vo.chart.Chart;
import com.munchan.chart_backend.vo.chart.ChartData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public AllCharts getCharts(String deviceName, String startDate, String endDate) throws NotExistDeviceException {
        return new AllCharts(
                new Chart(chartRepository.getDeviceCPUChartData(getDeviceIdByDeviceName(deviceName), startDate, endDate))
                , new Chart(chartRepository.getModelDisorderChartData(getDeviceIdByDeviceName(deviceName), startDate, endDate))
                , new Chart(chartRepository.getDisorderTypeChartData(getDeviceIdByDeviceName(deviceName), startDate, endDate))
                , new Chart(chartRepository.getDailyDisorderChartData(getDeviceIdByDeviceName(deviceName), startDate, endDate))
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
    public List<String> getAllDeviceName() {
        return chartRepository.getAllDeviceName();
    }

    @Override
    public ChartData getMaxErrorDevice() {
        return chartRepository.getMaxErrorDeviceName();
    }
}
