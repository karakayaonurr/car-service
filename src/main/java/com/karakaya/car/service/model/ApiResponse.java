package com.karakaya.car.service.model;

/**
 * Created by TCOKARAKAYA on 8.05.2022.
 */

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T>
{
    private String status;
    private String message;
    private T data;
}
