package com.booking.commons.service;

import com.booking.commons.entity.User;
import com.booking.commons.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service for User entity.
 * Methods: create, getById.
 */
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User create(User user) {
        return userRepository.save(user);
    }

    public Optional<User> getById(Long id) {
        return userRepository.findById(id);
    }

    public Optional<User> getByPhone(String phone) {
        return userRepository.findByPhone(phone);
    }
}
