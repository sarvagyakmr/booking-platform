package com.booking.commons.service.dto;

import com.booking.commons.dto.ResourceGroupRequest;
import com.booking.commons.dto.ResourceGroupResponse;
import com.booking.commons.entity.Resource;
import com.booking.commons.entity.ResourceGroup;
import com.booking.commons.service.ResourceGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * DTO service for ResourceGroup - mirrors methods with Request/Response conversion.
 * Handles add/remove which return Resource (mapped to DTO if needed).
 */
@Service
@RequiredArgsConstructor
public class ResourceGroupDtoService {

    private final ResourceGroupService resourceGroupService;

    private ResourceGroup toEntity(ResourceGroupRequest request) {
        if (request == null) return null;
        ResourceGroup group = new ResourceGroup();
        group.setName(request.getName());
        group.setDescription(request.getDescription());
        return group;
    }

    public ResourceGroupResponse create(ResourceGroupRequest request) {
        ResourceGroup entity = toEntity(request);
        ResourceGroup saved = resourceGroupService.create(entity);
        return ResourceGroupResponse.fromEntity(saved);
    }

    // add/remove return Resource; map to simple response or keep as-is
    public Resource addResourceToGroup(Long resourceId, Long groupId) {
        return resourceGroupService.addResourceToGroup(resourceId, groupId);
    }

    public Resource removeResourceFromGroup(Long resourceId) {
        return resourceGroupService.removeResourceFromGroup(resourceId);
    }

    public List<ResourceGroupResponse> getAll() {
        return resourceGroupService.getAll().stream()
                .map(ResourceGroupResponse::fromEntity)
                .toList();
    }
}