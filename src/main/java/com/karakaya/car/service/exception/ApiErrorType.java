package com.karakaya.car.service.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * Created by TCOKARAKAYA on 25.05.2022.
 */
@Getter
@AllArgsConstructor
public enum ApiErrorType {
    INTERNAL_SERVER_ERROR(100, "Internal Server Exception", HttpStatus.INTERNAL_SERVER_ERROR),
    FIELD_VALIDATION_ERROR(200, "Field Validation Exception", HttpStatus.BAD_REQUEST),
    AUTHENTICATION_ERROR(300, "Authentication Exception", HttpStatus.UNAUTHORIZED),
    CAR_NOT_FOUND_ERROR(21, "Car Not Found Exception", HttpStatus.NOT_FOUND),
    USER_NOT_FOUND_ERROR(22, "User Not Found Exception", HttpStatus.NOT_FOUND),
    ORDER_NOT_FOUND_ERROR(23,"Order Not Found Exception", HttpStatus.NOT_FOUND),
    CAR_EXISTS_ERROR(31, "Car Already Exists Exception", HttpStatus.NOT_ACCEPTABLE),
    USER_EXISTS_ERROR(32, "User Already Exists Exception", HttpStatus.NOT_ACCEPTABLE);

    private final int errorCode;
    private final String errorMessage;
    private final HttpStatus httpStatus;
}