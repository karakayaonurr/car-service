package com.karakaya.car.service.entity;

import com.karakaya.car.service.enums.GearType;
import com.karakaya.car.service.enums.VehicleColor;
import com.karakaya.car.service.enums.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
    private Long id;

    private String brand;

    private String model;

    private Long modelYear;

    private VehicleType vehicleType;

    private GearType gearType;

    private VehicleColor vehicleColor;
}
