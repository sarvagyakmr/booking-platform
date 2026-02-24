package com.booking.server.controller;

import com.booking.commons.dto.UserRequest;
import com.booking.commons.dto.UserResponse;
import com.booking.commons.service.dto.UserDtoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST Controller for User (uses UserDtoService).
 */
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController extends AbstractController {

    private final UserDtoService userDtoService;

    @PostMapping
    public ResponseEntity<UserResponse> create(@RequestBody UserRequest request) {
        return ResponseEntity.ok(userDtoService.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getById(@PathVariable(name = "id") Long id) {
        return userDtoService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/by-phone/{phone}")
    public ResponseEntity<UserResponse> getByPhone(@PathVariable(name = "phone") String phone) {
        return userDtoService.getByPhone(phone)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
