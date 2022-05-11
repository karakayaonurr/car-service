package com.karakaya.car.service.entity;

import com.karakaya.car.service.enums.Color;
import com.karakaya.car.service.enums.Gear;
import com.karakaya.car.service.enums.Type;
import com.karakaya.car.service.model.response.CarResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by TCOKARAKAYA on 27.04.2022.
 */
@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "car")
@ToString
public class Car extends BaseEntity
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brand;

    private String model;

    private Long modelYear;

    private Type type;

    private Gear gear;

    private Color color;

    private BigDecimal price;

    public static CarResponse toCarResponse (Car car){
        return CarResponse.builder()
                .brand(car.getBrand())
                .color(car.getColor())
                .gear(car.getGear())
                .model(car.getModel())
                .modelYear(car.getModelYear())
                .type(car.getType())
                .price(car.getPrice())
                .build();
    }

    public static List<CarResponse> toCarResponseList(List<Car> carList) {
        return carList.stream().map(Car::toCarResponse).collect(Collectors.toList());
    }
}
