package com.karakaya.car.service.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

/**
 * Created by TCOKARAKAYA on 25.05.2022.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApiErrorResponse {
    private String code;
    private String message;
    private HttpStatus status;
}
