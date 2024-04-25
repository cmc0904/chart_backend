package com.munchan.chart_backend.controller;

import com.munchan.chart_backend.exception.NotExistDeviceException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ChartControllerAdvice {
    @ExceptionHandler(NotExistDeviceException.class)
    public Result updateFailedException() {
        return new Result("NOT_EXIST_DEVICE");
    }
}
