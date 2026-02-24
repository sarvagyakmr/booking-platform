package com.booking.server.controller;

import com.booking.commons.dto.ResourceRequest;
import com.booking.commons.dto.ResourceResponse;
import com.booking.commons.service.dto.ResourceDtoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST Controller for Resource (uses ResourceDtoService).
 * Endpoints mirror DTO service methods for the booking platform APIs.
 */
@RestController
@RequestMapping("/api/resources")
@RequiredArgsConstructor
public class ResourceController extends AbstractController {

    private final ResourceDtoService resourceDtoService;

    @PostMapping
    public ResponseEntity<ResourceResponse> create(@RequestBody ResourceRequest request) {
        Long clientId = getClientId();
        request.setClientId(clientId);
        return ResponseEntity.ok(resourceDtoService.create(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResourceResponse> getById(@PathVariable(name = "id") Long id) {
        Long clientId = getClientId();
        return resourceDtoService.getById(id, clientId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/by-name")
    public ResponseEntity<ResourceResponse> getByName(@RequestParam(name = "name") String name) {
        Long clientId = getClientId();
        return resourceDtoService.getByName(name, clientId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}