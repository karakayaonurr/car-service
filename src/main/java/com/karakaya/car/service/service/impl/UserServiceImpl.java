package com.karakaya.car.service.service.impl;

import com.karakaya.car.service.entity.Car;
import com.karakaya.car.service.entity.User;
import com.karakaya.car.service.model.request.UserCreateRequest;
import com.karakaya.car.service.model.response.CarResponse;
import com.karakaya.car.service.model.response.UserResponse;
import com.karakaya.car.service.repository.UserRepository;
import com.karakaya.car.service.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Created by TCOKARAKAYA on 9.05.2022.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService
{
    private final UserRepository userRepository;

    @Override
    public UserResponse createUser(UserCreateRequest request)
    {
        User user = userRepository.save(User.builder()
                .name(request.getName())
                .surname(request.getSurname())
                .birhYear(request.getBirhYear())
                .gender(request.getGender())
                .address(request.getAddress())
                .gsmNo(request.getGsmNo())
                .budget(request.getBudget())
                .build());

        log.info("User saved successfully: {}", user);

        return UserResponse.builder()
                .name(user.getName())
                .surname(user.getSurname())
                .birhYear(user.getBirhYear())
                .gender(user.getGender())
                .address(user.getAddress())
                .gsmNo(user.getGsmNo())
                .budget(user.getBudget())
                .build();
    }

    @Override
    public List<UserResponse> getUsersByName(String name)
    {
        List<User> userList = userRepository.findAllByName(name);

        if (!userList.isEmpty())
        {
            List<UserResponse> userResponseList = new ArrayList<>();

            userList.forEach(user -> {
                UserResponse userResponse = UserResponse.builder()
                        .name(user.getName())
                        .surname(user.getSurname())
                        .birhYear(user.getBirhYear())
                        .gender(user.getGender())
                        .address(user.getAddress())
                        .gsmNo(user.getGsmNo())
                        .budget(user.getBudget())
                        .build();

                userResponseList.add(userResponse);
            });

            log.info("Users found: {}", userList);

            return userResponseList;
        }
        else
        {
            return Collections.emptyList();
        }
    }

    @Override
    public UserResponse getUserById(Long id)
    {
        Optional<User> user = userRepository.findById(id);

        if (user.isPresent())
        {
            User userPresent = user.get();

            log.info("Users found: {}", userPresent);

            return UserResponse.builder()
                    .name(userPresent.getName())
                    .surname(userPresent.getSurname())
                    .birhYear(userPresent.getBirhYear())
                    .gender(userPresent.getGender())
                    .address(userPresent.getAddress())
                    .gsmNo(userPresent.getGsmNo())
                    .budget(userPresent.getBudget())
                    .build();
        }
        else
        {
            return new UserResponse();
        }
    }
}
