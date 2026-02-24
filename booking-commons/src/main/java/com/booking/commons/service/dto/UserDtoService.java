package com.booking.commons.service.dto;

import com.booking.commons.dto.UserRequest;
import com.booking.commons.dto.UserResponse;
import com.booking.commons.entity.User;
import com.booking.commons.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * DTO service for User - mirrors UserService methods with Request/Response conversion.
 */
@Service
@RequiredArgsConstructor
public class UserDtoService {

    private final UserService userService;

    private User toEntity(UserRequest request) {
        if (request == null) return null;
        User user = new User();
        user.setPhone(request.getPhone());
        user.setPassword(request.getPassword());
        user.setClientId(request.getClientId());
        return user;
    }

    public UserResponse create(UserRequest request) {
        User entity = toEntity(request);
        User saved = userService.create(entity);
        return UserResponse.fromEntity(saved);
    }

    public Optional<UserResponse> getById(Long id) {
        return userService.getById(id)
                .map(UserResponse::fromEntity);
    }

    public Optional<UserResponse> getByPhone(String phone) {
        return userService.getByPhone(phone)
                .map(UserResponse::fromEntity);
    }
}
