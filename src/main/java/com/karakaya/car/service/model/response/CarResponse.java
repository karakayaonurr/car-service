package com.karakaya.car.service.model.response;

import com.karakaya.car.service.enums.Color;
import com.karakaya.car.service.enums.Gear;
import com.karakaya.car.service.enums.Type;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by TCOKARAKAYA on 8.05.2022.
 */
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CarResponse
{
    private String brand;
    private String model;
    private Long modelYear;
    private Type type;
    private Gear gear;
    private Color color;
    private Long price;
}
