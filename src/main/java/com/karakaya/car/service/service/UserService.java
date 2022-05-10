package com.karakaya.car.service.service;

import com.karakaya.car.service.model.request.UserCreateRequest;
import com.karakaya.car.service.model.response.UserResponse;

import java.util.List;

/**
 * Created by TCOKARAKAYA on 9.05.2022.
 */
public interface UserService
{
    UserResponse createUser(UserCreateRequest userCreateRequest);

    List<UserResponse> getUsersByName(String brand);

    UserResponse getUserById(Long id);
}
