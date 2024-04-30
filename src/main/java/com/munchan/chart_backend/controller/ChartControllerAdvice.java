package com.munchan.chart_backend.controller;

import com.munchan.chart_backend.exception.NotExistDeviceException;
import com.munchan.chart_backend.vo.res.ResponseErrorResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ChartControllerAdvice {
    @ExceptionHandler(NotExistDeviceException.class)
    public ResponseErrorResult updateFailedException() {
        return new ResponseErrorResult("NOT_EXIST_DEVICE");
    }
}
