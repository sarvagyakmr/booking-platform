package com.booking.server.controller;

import com.booking.commons.dto.ResourceItemRequest;
import com.booking.commons.dto.ResourceItemResponse;
import com.booking.commons.service.dto.ResourceItemDtoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST Controller for ResourceItem (uses ResourceItemDtoService).
 */
@RestController
@RequestMapping("/api/resource-items")
@RequiredArgsConstructor
public class ResourceItemController extends AbstractController {

    private final ResourceItemDtoService resourceItemDtoService;

    @PostMapping
    public ResponseEntity<ResourceItemResponse> create(@RequestBody ResourceItemRequest request) {
        Long clientId = getClientId();
        request.setClientId(clientId);
        return ResponseEntity.ok(resourceItemDtoService.create(request));
    }

    @GetMapping("/by-resource/{resourceId}")
    public ResponseEntity<List<ResourceItemResponse>> getAllByResourceId(@PathVariable(name = "resourceId") Long resourceId) {
        Long clientId = getClientId();
        return ResponseEntity.ok(resourceItemDtoService.getAllByResourceId(resourceId, clientId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResourceItemResponse> getById(@PathVariable(name = "id") Long id) {
        Long clientId = getClientId();
        return resourceItemDtoService.getById(id, clientId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}