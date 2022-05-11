package com.karakaya.car.service.service.impl;

import com.karakaya.car.service.entity.Car;
import com.karakaya.car.service.entity.Order;
import com.karakaya.car.service.entity.User;
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

        if (user.isPresent() && !carList.isEmpty())
        {
            User userPresent = user.get();

            Order order = orderRepository.save(Order.builder()
                    .user(userPresent)
                    .carList(carList)
                    .price(calculateOrderPrice(carList))
                    .build());

            return Order.toOrderResponse(order);
        }
        else
        {
            return new OrderResponse();
        }
    }

    private BigDecimal calculateOrderPrice(List<Car> carList)
    {
        return carList.stream().map(Car::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
