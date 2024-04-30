package com.munchan.chart_backend.vo.res;


public class ResponseErrorResult {
    private final String message;

    public ResponseErrorResult(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
