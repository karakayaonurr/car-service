package com.karakaya.car.service.service.impl;

import com.karakaya.car.service.entity.Car;
import com.karakaya.car.service.entity.Order;
import com.karakaya.car.service.entity.User;
import com.karakaya.car.service.exception.CarNotFoundException;
import com.karakaya.car.service.exception.OrderNotFoundException;
import com.karakaya.car.service.exception.UserNotFoundException;
import com.karakaya.car.service.model.request.OrderCreateRequest;
import com.karakaya.car.service.model.response.OrderResponse;
import com.karakaya.car.service.model.response.UserResponse;
import com.karakaya.car.service.repository.CarRepository;
import com.karakaya.car.service.repository.OrderRepository;
import com.karakaya.car.service.repository.UserRepository;
import com.karakaya.car.service.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static com.karakaya.car.service.exception.ApiErrorType.CAR_NOT_FOUND_ERROR;
import static com.karakaya.car.service.exception.ApiErrorType.USER_NOT_FOUND_ERROR;

/**
 * Created by TCOKARAKAYA on 11.05.2022.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService
{
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final CarRepository carRepository;

    @Override
    public OrderResponse createOrder(OrderCreateRequest request)
    {
        Optional<User> user = userRepository.findById(request.getUserId());
        List<Car> carList = carRepository.findAllByIdIn(request.getCarIdList());

        if (user.isEmpty()) {
            throw new UserNotFoundException(USER_NOT_FOUND_ERROR.getErrorCode(),
                    USER_NOT_FOUND_ERROR.getErrorMessage(),
                    USER_NOT_FOUND_ERROR.getHttpStatus());
        }

        if (carList.isEmpty()) {
            throw new CarNotFoundException(CAR_NOT_FOUND_ERROR.getErrorCode(),
                    CAR_NOT_FOUND_ERROR.getErrorMessage(),
                    CAR_NOT_FOUND_ERROR.getHttpStatus());
        }

        User userPresent = user.get();

        Order order = orderRepository.save(Order.builder()
                .user(userPresent)
                .carList(carList)
                .price(calculateOrderPrice(carList))
                .build());

        return Order.toOrderResponse(order);
    }

    private BigDecimal calculateOrderPrice(List<Car> carList)
    {
        return carList.stream().map(Car::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
