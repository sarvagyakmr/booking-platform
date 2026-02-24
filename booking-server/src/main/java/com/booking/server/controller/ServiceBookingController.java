package com.booking.server.controller;

import com.booking.commons.dto.ServiceBookingRequest;
import com.booking.commons.dto.ServiceBookingResponse;
import com.booking.commons.service.dto.ServiceBookingDtoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST Controller for ServiceBooking (uses ServiceBookingDtoService).
 */
@RestController
@RequestMapping("/api/service-bookings")
@RequiredArgsConstructor
public class ServiceBookingController extends AbstractController {

    private final ServiceBookingDtoService serviceBookingDtoService;

    @PostMapping
    public ResponseEntity<ServiceBookingResponse> create(@RequestBody ServiceBookingRequest request) {
        Long clientId = getClientId();
        request.setClientId(clientId);
        return ResponseEntity.ok(serviceBookingDtoService.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceBookingResponse> getById(@PathVariable(name = "id") Long id) {
        Long clientId = getClientId();
        return serviceBookingDtoService.getById(id, clientId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}