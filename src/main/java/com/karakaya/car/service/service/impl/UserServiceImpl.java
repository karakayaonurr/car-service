package com.karakaya.car.service.service.impl;

import com.karakaya.car.service.entity.User;
import com.karakaya.car.service.exception.CarAlreadyExistsException;
import com.karakaya.car.service.exception.UserAlreadyExistsException;
import com.karakaya.car.service.exception.UserNotFoundException;
import com.karakaya.car.service.model.request.UserCreateRequest;
import com.karakaya.car.service.model.response.UserResponse;
import com.karakaya.car.service.repository.UserRepository;
import com.karakaya.car.service.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.karakaya.car.service.exception.ApiErrorType.CAR_EXISTS_ERROR;
import static com.karakaya.car.service.exception.ApiErrorType.USER_EXISTS_ERROR;
import static com.karakaya.car.service.exception.ApiErrorType.USER_NOT_FOUND_ERROR;

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
        Optional<User> userCheck = userRepository.findByNameAndSurnameAndBirthYearAndGenderAndGsmNo(request.getName(),
                request.getSurname(),request.getBirthYear(),request.getGender(),request.getGsmNo());

        if (userCheck.isEmpty()) {
            throw new UserAlreadyExistsException(USER_EXISTS_ERROR.getErrorCode(),
                    USER_EXISTS_ERROR.getErrorMessage(),
                    USER_EXISTS_ERROR.getHttpStatus());
        }

        User user = userRepository.save(User.builder()
                .name(request.getName())
                .surname(request.getSurname())
                .birthYear(request.getBirthYear())
                .gender(request.getGender())
                .address(request.getAddress())
                .gsmNo(request.getGsmNo())
                .budget(request.getBudget())
                .build());

        log.info("User saved successfully: {}", user);

        return UserResponse.builder()
                .name(user.getName())
                .surname(user.getSurname())
                .birthYear(user.getBirthYear())
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
            log.info("Users found: {}", userList);

            return User.toUserResponseList(userList);
        }
        else
        {
            throw new UserNotFoundException(USER_NOT_FOUND_ERROR.getErrorCode(),
                    USER_NOT_FOUND_ERROR.getErrorMessage(),
                    USER_NOT_FOUND_ERROR.getHttpStatus());
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

           return User.toUserResponse(userPresent);
        }
        else
        {
            throw new UserNotFoundException(USER_NOT_FOUND_ERROR.getErrorCode(),
                    USER_NOT_FOUND_ERROR.getErrorMessage(),
                    USER_NOT_FOUND_ERROR.getHttpStatus());
        }
    }
}
