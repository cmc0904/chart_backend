package com.munchan.chart_backend.vo.chart;

public class ChartData {
    private final String title;
    private final Integer value;

    public ChartData(String title, Integer value) {

        this.title = title;
        this.value = value;
    }


    public String getTitle() {
        return title;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "ChartData{" +
                "title='" + title + '\'' +
                ", value=" + value +
                '}';
    }
}
