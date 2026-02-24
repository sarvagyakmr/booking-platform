package com.booking.server.controller;

import com.booking.commons.dto.ServiceRequest;
import com.booking.commons.dto.ServiceResponse;
import com.booking.commons.service.dto.ServiceDtoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST Controller for Service (uses ServiceDtoService).
 */
@RestController
@RequestMapping("/api/services")
@RequiredArgsConstructor
public class ServiceController extends AbstractController {

    private final ServiceDtoService serviceDtoService;

    @PostMapping
    public ResponseEntity<ServiceResponse> create(@RequestBody ServiceRequest request) {
        Long clientId = getClientId();
        request.setClientId(clientId);
        return ResponseEntity.ok(serviceDtoService.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceResponse> getById(@PathVariable(name = "id") Long id) {
        Long clientId = getClientId();
        return serviceDtoService.getById(id, clientId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/by-group/{resourceGroupId}")
    public ResponseEntity<List<ServiceResponse>> getByResourceGroupId(@PathVariable(name = "resourceGroupId") Long resourceGroupId) {
        Long clientId = getClientId();
        return ResponseEntity.ok(serviceDtoService.getByResourceGroupId(resourceGroupId, clientId));
    }
}