package com.karakaya.car.service.entity;

import com.karakaya.car.service.enums.Gear;
import com.karakaya.car.service.enums.Color;
import com.karakaya.car.service.enums.Type;
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

    private Type type;

    private Gear gear;

    private Color color;
}
