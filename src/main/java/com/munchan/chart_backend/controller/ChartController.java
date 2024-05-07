package com.munchan.chart_backend.controller;

import com.munchan.chart_backend.exception.NotExistDeviceException;
import com.munchan.chart_backend.service.ChartService;

import com.munchan.chart_backend.vo.chart.AllCharts;
import com.munchan.chart_backend.vo.chart.ChartData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/chart")
public class ChartController {
    private final ChartService chartService;

    @Autowired
    public ChartController(ChartService chartService) {
        this.chartService = chartService;
    }

    @GetMapping("/searchChart")
    public AllCharts getChartData(String deviceName, String startDate, String endDate) throws NotExistDeviceException {
        System.out.printf("시작일 : %s | 끝나는 일 : %s%n", startDate, endDate);
        return chartService.getChart(deviceName, startDate, endDate);
    }

    @GetMapping("/getChartData")
    public AllCharts getChartData(String startDate, String endDate) {
        System.out.printf("시작일 : %s | 끝나는 일 : %s%n", startDate, endDate);
        return chartService.getChart(startDate, endDate);
    }

    @GetMapping("/getAllDeviceName")
    public List<String> getAllDeviceName(String deviceName) {
        return chartService.getAllDeviceName(deviceName);
    }

    @GetMapping("/getMaxErrorDeviceName")
    public ChartData getMaxErrorDeviceName() {
        return chartService.getMaxErrorDevice();
    }

}
