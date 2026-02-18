package com.booking.server.controller;

import com.booking.commons.dto.ServiceRequest;
import com.booking.commons.dto.ServiceResponse;
import com.booking.commons.service.dto.ServiceDtoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * REST Controller for Service (uses ServiceDtoService).
 */
@RestController
@RequestMapping("/api/services")
@RequiredArgsConstructor
public class ServiceController {

    private final ServiceDtoService serviceDtoService;

    @PostMapping
    public ResponseEntity<ServiceResponse> create(@RequestBody ServiceRequest request) {
        return ResponseEntity.ok(serviceDtoService.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceResponse> getById(@PathVariable(name = "id") Long id) {
        return serviceDtoService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/by-group/{resourceGroupId}")
    public ResponseEntity<List<ServiceResponse>> getByResourceGroupId(@PathVariable(name = "resourceGroupId") Long resourceGroupId) {
        return ResponseEntity.ok(serviceDtoService.getByResourceGroupId(resourceGroupId));
    }
}