package com.karakaya.car.service.model.response;

import com.karakaya.car.service.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * Created by TCOKARAKAYA on 9.05.2022.
 */
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse
{
    private String name;
    private String surname;
    private Long birthYear;
    private Gender gender;
    private String address;
    private String gsmNo;
    private BigDecimal budget;
}
