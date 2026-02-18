package com.booking.server.controller;

import com.booking.commons.dto.ServiceBookingRequest;
import com.booking.commons.dto.ServiceBookingResponse;
import com.booking.commons.service.dto.ServiceBookingDtoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * REST Controller for ServiceBooking (uses ServiceBookingDtoService).
 */
@RestController
@RequestMapping("/api/service-bookings")
@RequiredArgsConstructor
public class ServiceBookingController {

    private final ServiceBookingDtoService serviceBookingDtoService;

    @PostMapping
    public ResponseEntity<ServiceBookingResponse> create(@RequestBody ServiceBookingRequest request) {
        return ResponseEntity.ok(serviceBookingDtoService.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceBookingResponse> getById(@PathVariable(name = "id") Long id) {
        return serviceBookingDtoService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}