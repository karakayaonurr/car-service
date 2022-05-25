package com.karakaya.car.service.repository;

import com.karakaya.car.service.entity.Car;
import com.karakaya.car.service.enums.Color;
import com.karakaya.car.service.enums.Gear;
import com.karakaya.car.service.enums.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by TCOKARAKAYA on 8.05.2022.
 */
@Repository
public interface CarRepository extends JpaRepository<Car, Long>
{
    List<Car> findAllByBrand(String brand);

    List<Car> findAllByIdIn(List<Long> idList);

    Optional<Car> findByBrandAndModelAndModelYearAndTypeAndGearAndColor(String brand, String model, Long modelYear, Type type, Gear gear, Color color);
}
