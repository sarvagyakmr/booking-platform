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
public class ResourceItemController {

    private final ResourceItemDtoService resourceItemDtoService;

    @PostMapping
    public ResponseEntity<ResourceItemResponse> create(@RequestBody ResourceItemRequest request) {
        return ResponseEntity.ok(resourceItemDtoService.create(request));
    }

    @GetMapping("/by-resource/{resourceId}")
    public ResponseEntity<List<ResourceItemResponse>> getAllByResourceId(@PathVariable(name = "resourceId") Long resourceId) {
        return ResponseEntity.ok(resourceItemDtoService.getAllByResourceId(resourceId));
    }
}