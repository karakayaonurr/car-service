package com.karakaya.car.service.model.request;

import com.karakaya.car.service.enums.Gender;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * Created by TCOKARAKAYA on 9.05.2022.
 */
@Getter
@Builder
@ToString
public class UserCreateRequest
{
    private String name;
    private String surname;
    private Long birthYear;
    private Gender gender;
    private String address;
    private String gsmNo;
    private BigDecimal budget;
}
