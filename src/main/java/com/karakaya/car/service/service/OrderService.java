package com.karakaya.car.service.service;

import com.karakaya.car.service.model.request.OrderCreateRequest;
import com.karakaya.car.service.model.response.OrderResponse;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by TCOKARAKAYA on 11.05.2022.
 */
public interface OrderService
{
    OrderResponse createOrder (OrderCreateRequest orderCreateRequest);
}
