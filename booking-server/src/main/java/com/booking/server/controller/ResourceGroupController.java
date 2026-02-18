package com.booking.server.controller;

import com.booking.commons.dto.ResourceGroupRequest;
import com.booking.commons.dto.ResourceGroupResponse;
import com.booking.commons.entity.Resource;
import com.booking.commons.service.dto.ResourceGroupDtoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST Controller for ResourceGroup (uses ResourceGroupDtoService).
 * Add/remove use POST for simplicity (ID refs only).
 */
@RestController
@RequestMapping("/api/resource-groups")
@RequiredArgsConstructor
public class ResourceGroupController {

    private final ResourceGroupDtoService resourceGroupDtoService;

    @PostMapping
    public ResponseEntity<ResourceGroupResponse> create(@RequestBody ResourceGroupRequest request) {
        return ResponseEntity.ok(resourceGroupDtoService.create(request));
    }

    @PostMapping("/{groupId}/add-resource/{resourceId}")
    public ResponseEntity<Resource> addResourceToGroup(@PathVariable(name = "resourceId") Long resourceId, @PathVariable(name = "groupId") Long groupId) {
        return ResponseEntity.ok(resourceGroupDtoService.addResourceToGroup(resourceId, groupId));
    }

    @PostMapping("/remove-resource/{resourceId}")
    public ResponseEntity<Resource> removeResourceFromGroup(@PathVariable(name = "resourceId") Long resourceId) {
        return ResponseEntity.ok(resourceGroupDtoService.removeResourceFromGroup(resourceId));
    }

    @GetMapping
    public ResponseEntity<List<ResourceGroupResponse>> getAll() {
        return ResponseEntity.ok(resourceGroupDtoService.getAll());
    }
}