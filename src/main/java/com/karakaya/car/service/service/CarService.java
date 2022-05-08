package com.karakaya.car.service.service;

import com.karakaya.car.service.model.request.CarCreateRequest;
import com.karakaya.car.service.model.response.CarResponse;

import java.util.List;

/**
 * Created by TCOKARAKAYA on 8.05.2022.
 */
public interface CarService
{
    CarResponse createCar(CarCreateRequest carCreateRequest);

    List<CarResponse> getCarsByBrand(String brand);

    CarResponse getCarById(Long id);
}
