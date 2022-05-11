package com.karakaya.car.service.controller;

import com.karakaya.car.service.model.ApiResponse;
import com.karakaya.car.service.model.request.OrderCreateRequest;
import com.karakaya.car.service.model.response.OrderResponse;
import com.karakaya.car.service.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by TCOKARAKAYA on 11.05.2022.
 */
@RestController
@RequestMapping("api/order-service")
@RequiredArgsConstructor
@Slf4j
public class OrderController
{
    private final OrderService orderService;

    @PostMapping("/create")
    public ApiResponse<OrderResponse> createOrder(@RequestBody OrderCreateRequest request) {

        log.info("Order create service called by request {}", request);

        OrderResponse orderResponse = orderService.createOrder(request);

        return ApiResponse.<OrderResponse>builder()
                .data(orderResponse)
                .status("0")
                .message("success")
                .build();
    }
}
