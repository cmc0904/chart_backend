package com.munchan.chart_backend.exception;

public class NotExistDeviceException extends Exception {

    private static final long serialVersionUID = 1L;

    public NotExistDeviceException() {
        super("NOT_EXIST_DEVICE");
    }

}