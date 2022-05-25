package com.karakaya.car.service.exception;

import org.springframework.http.HttpStatus;

/**
 * Created by TCOKARAKAYA on 25.05.2022.
 */
public class UserNotFoundException extends BaseRuntimeException {

    public UserNotFoundException(int errorCode, String errorMessage, HttpStatus httpStatus) {
        super(errorCode, errorMessage, httpStatus);
    }
}