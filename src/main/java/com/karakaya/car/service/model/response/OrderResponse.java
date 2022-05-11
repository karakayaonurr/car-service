package com.karakaya.car.service.model.response;

import com.karakaya.car.service.entity.Car;
import com.karakaya.car.service.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by TCOKARAKAYA on 11.05.2022.
 */
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponse
{
    private BigDecimal price;
    private UserResponse user;
    private List<CarResponse> carList;
}
