package com.karakaya.car.service.model.request;

import com.karakaya.car.service.enums.Color;
import com.karakaya.car.service.enums.Gear;
import com.karakaya.car.service.enums.Type;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * Created by TCOKARAKAYA on 8.05.2022.
 */
@Getter
@Builder
@ToString
public class CarCreateRequest
{
    private String brand;
    private String model;
    private Long modelYear;
    private Type type;
    private Gear gear;
    private Color color;
    private Long price;
}
