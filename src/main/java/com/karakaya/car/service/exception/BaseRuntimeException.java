package com.karakaya.car.service.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * Created by TCOKARAKAYA on 25.05.2022.
 */
@Getter
public class BaseRuntimeException extends RuntimeException {

    private final int errorCode;
    private final String errorMessage;
    private final HttpStatus httpStatus;

    public BaseRuntimeException(int errorCode, String errorMessage, HttpStatus httpStatus) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.httpStatus = httpStatus;
    }
}