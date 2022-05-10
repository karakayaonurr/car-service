package com.karakaya.car.service.service.impl;

import com.karakaya.car.service.entity.Car;
import com.karakaya.car.service.model.request.CarCreateRequest;
import com.karakaya.car.service.model.response.CarResponse;
import com.karakaya.car.service.repository.CarRepository;
import com.karakaya.car.service.service.CarService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Created by TCOKARAKAYA on 8.05.2022.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class CarServiceImpl implements CarService
{
    private final CarRepository carRepository;

    @Override
    public CarResponse createCar(CarCreateRequest request)
    {
        Car car = carRepository.save(Car.builder()
                .brand(request.getBrand())
                .color(request.getColor())
                .gear(request.getGear())
                .model(request.getModel())
                .modelYear(request.getModelYear())
                .type(request.getType())
                .price(request.getPrice())
                .build());

        log.info("Car saved successfully: {}", car);

        return CarResponse.builder()
                .brand(car.getBrand())
                .color(car.getColor())
                .gear(car.getGear())
                .model(car.getModel())
                .modelYear(car.getModelYear())
                .type(car.getType())
                .price(request.getPrice())
                .build();
    }

    @Override
    public List<CarResponse> getCarsByBrand(String brand)
    {
        List<Car> carList = carRepository.findAllByBrand(brand);

        if (!carList.isEmpty())
        {
            List<CarResponse> carResponseList = new ArrayList<>();

            carList.forEach(car -> {
                CarResponse carResponse = CarResponse.builder()
                        .brand(car.getBrand())
                        .color(car.getColor())
                        .gear(car.getGear())
                        .model(car.getModel())
                        .modelYear(car.getModelYear())
                        .type(car.getType())
                        .price(car.getPrice())
                        .build();

                carResponseList.add(carResponse);
            });

            log.info("Cars found: {}", carList);

            return carResponseList;
        }
        else
        {
            return Collections.emptyList();
        }
    }

    @Override
    public CarResponse getCarById(Long id)
    {
        Optional<Car> car = carRepository.findById(id);

        if (car.isPresent())
        {
            Car carPresent = car.get();

            log.info("Cars found: {}", carPresent);

            return CarResponse.builder()
                    .brand(carPresent.getBrand())
                    .color(carPresent.getColor())
                    .gear(carPresent.getGear())
                    .model(carPresent.getModel())
                    .modelYear(carPresent.getModelYear())
                    .type(carPresent.getType())
                    .price(carPresent.getPrice())
                    .build();
        }
        else
        {
            return new CarResponse();
        }
    }

}
