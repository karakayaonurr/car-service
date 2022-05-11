package com.karakaya.car.service.entity;

import com.karakaya.car.service.enums.Gender;
import com.karakaya.car.service.model.response.UserResponse;
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
 * Created by TCOKARAKAYA on 9.05.2022.
 */
@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@ToString
public class User extends BaseEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String surname;

    private Long birthYear;

    private Gender gender;

    private String address;

    private String gsmNo;

    private BigDecimal budget;

    public static UserResponse toUserResponse(User user) {
        return UserResponse.builder()
                .name(user.getName())
                .surname(user.getSurname())
                .birthYear(user.getBirthYear())
                .gender(user.getGender())
                .address(user.getAddress())
                .gsmNo(user.getGsmNo())
                .budget(user.getBudget())
                .build();
    }

    public static List<UserResponse> toUserResponseList (List<User> userList){
        return userList.stream().map(User::toUserResponse).collect(Collectors.toList());
    };
}
