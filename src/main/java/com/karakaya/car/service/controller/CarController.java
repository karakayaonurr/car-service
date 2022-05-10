package com.karakaya.car.service.controller;

import com.karakaya.car.service.model.ApiResponse;
import com.karakaya.car.service.model.request.CarCreateRequest;
import com.karakaya.car.service.model.response.CarResponse;
import com.karakaya.car.service.service.CarService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by TCOKARAKAYA on 8.05.2022.
 */
@RestController
@RequestMapping("api/car-service")
@RequiredArgsConstructor
@Slf4j
public class CarController
{
    private final CarService carService;

    @PostMapping("/create")
    public ApiResponse<CarResponse> createCar(@RequestBody CarCreateRequest request)
    {
        log.info("Car create service called by request {}", request);

        CarResponse carResponse = carService.createCar(request);

        return ApiResponse.<CarResponse>builder()
                .data(carResponse)
                .status("0")
                .message("success")
                .build();
    }

    @GetMapping("/getByBrand/{brand}")
    public ApiResponse<List<CarResponse>> getCarsByBrand(@PathVariable String brand)
    {
        log.info("getCarsByBrand called with: {}", brand);

        List<CarResponse> carResponseList = carService.getCarsByBrand(brand);

        return ApiResponse.<List<CarResponse>>builder()
                .data(carResponseList)
                .status("0")
                .message("success")
                .build();
    }

    @GetMapping("/getById/{id}")
    public ApiResponse<CarResponse> getCarById(@PathVariable Long id)
    {
        log.info("getCarsById called with: {}", id);

        CarResponse carResponse = carService.getCarById(id);

        return ApiResponse.<CarResponse>builder()
                .data(carResponse)
                .status("0")
                .message("success")
                .build();
    }
}
