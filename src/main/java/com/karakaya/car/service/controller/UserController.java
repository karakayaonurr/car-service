package com.karakaya.car.service.controller;

import com.karakaya.car.service.model.ApiResponse;
import com.karakaya.car.service.model.request.UserCreateRequest;
import com.karakaya.car.service.model.response.UserResponse;
import com.karakaya.car.service.service.UserService;
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
 * Created by TCOKARAKAYA on 9.05.2022.
 */
@RestController
@RequestMapping("api/user-service")
@RequiredArgsConstructor
@Slf4j
public class UserController
{
    private final UserService userService;

    @PostMapping("/create")
    public ApiResponse<UserResponse> createUser(@RequestBody UserCreateRequest request)
    {
        log.info("User create service called by request {}", request);

        UserResponse userResponse = userService.createUser(request);

        return ApiResponse.<UserResponse>builder()
                .data(userResponse)
                .status("0")
                .message("success")
                .build();
    }

    @GetMapping("/getByName/{name}")
    public ApiResponse<List<UserResponse>> getUsersByName(@PathVariable String name)
    {
        log.info("getUsersByName called with: {}", name);

        List<UserResponse> userResponseList = userService.getUsersByName(name);

        return ApiResponse.<List<UserResponse>>builder()
                .data(userResponseList)
                .status("0")
                .message("success")
                .build();
    }

    @GetMapping("/getById/{id}")
    public ApiResponse<UserResponse> getUserById(@PathVariable Long id)
    {
        log.info("getUserById called with: {}", id);

        UserResponse userResponse = userService.getUserById(id);

        return ApiResponse.<UserResponse>builder()
                .data(userResponse)
                .status("0")
                .message("success")
                .build();
    }
}
