package com.karakaya.car.service.repository;

import com.karakaya.car.service.entity.User;
import com.karakaya.car.service.enums.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

/**
 * Created by TCOKARAKAYA on 9.05.2022.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>
{
    List<User> findAllByName(String name);

    Optional<User> findByNameAndSurnameAndBirthYearAndGenderAndGsmNo(String name, String surname, Long birthYear, Gender gender, String gsmNo);
}
