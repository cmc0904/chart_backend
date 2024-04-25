package com.munchan.chart_backend.controller;

import com.munchan.chart_backend.exception.NotExistDeviceException;
import com.munchan.chart_backend.service.ChartService;
import com.munchan.chart_backend.vo.chart.AllCharts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        if(startDate == null || endDate == null) {
            return chartService.getCharts(deviceName);
        }

        return chartService.getCharts(deviceName, startDate, endDate);
    }

}
