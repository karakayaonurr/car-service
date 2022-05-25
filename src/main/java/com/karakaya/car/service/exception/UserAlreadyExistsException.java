package com.karakaya.car.service.exception;

import org.springframework.http.HttpStatus;

/**
 * Created by TCOKARAKAYA on 25.05.2022.
 */
public class UserAlreadyExistsException extends BaseRuntimeException {

    public UserAlreadyExistsException(int errorCode, String errorMessage, HttpStatus httpStatus) {
        super(errorCode, errorMessage, httpStatus);
    }
}