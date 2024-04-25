package com.munchan.chart_backend.service;

import com.munchan.chart_backend.exception.NotExistDeviceException;
import com.munchan.chart_backend.repository.ChartRepository;
import com.munchan.chart_backend.vo.chart.AllCharts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChatServiceImpl implements ChartService {
    private final ChartRepository chartRepository;

    @Autowired
    public ChatServiceImpl(ChartRepository chartRepository) {
        this.chartRepository = chartRepository;
    }

    @Override
    public AllCharts getCharts(String deviceName) throws NotExistDeviceException {
        return new AllCharts(
                chartRepository.getDeviceCPUChartData(getDeviceIdByDeviceName(deviceName), null, null)
                , chartRepository.getModelDisorderChartData(getDeviceIdByDeviceName(deviceName), null, null)
                , chartRepository.getDisorderTypeChartData(getDeviceIdByDeviceName(deviceName), null, null)
                , chartRepository.getDailyDisorderChartData(getDeviceIdByDeviceName(deviceName), null, null)
        );
    }

    @Override
    public AllCharts getCharts(String deviceName, String startDate, String endDate) throws NotExistDeviceException {
        String startDay = startDate + " 00:00:00";
        String endDay = endDate + " 23:59:59";

        return new AllCharts(
                chartRepository.getDeviceCPUChartData(getDeviceIdByDeviceName(deviceName), startDay, endDay)
                , chartRepository.getModelDisorderChartData(getDeviceIdByDeviceName(deviceName), startDay, endDay)
                , chartRepository.getDisorderTypeChartData(getDeviceIdByDeviceName(deviceName), startDay, endDay)
                , chartRepository.getDailyDisorderChartData(getDeviceIdByDeviceName(deviceName), startDay, endDay)
        );
    }

    @Override
    public Integer getDeviceIdByDeviceName(String deviceName) throws NotExistDeviceException {
        Optional<Integer> foundDeviceName = chartRepository.getDeviceIdByDeviceName(deviceName);

        if (foundDeviceName.isPresent()) {
            return foundDeviceName.get();
        } else {
            throw new NotExistDeviceException();
        }
    }
}
