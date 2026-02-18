package com.booking.commons.service.dto;

import com.booking.commons.dto.ResourceRequest;
import com.booking.commons.dto.ResourceResponse;
import com.booking.commons.entity.Resource;
import com.booking.commons.service.ResourceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * DTO service for Resource - mirrors ResourceService methods but uses Request/Response DTOs.
 * Handles conversion to/from entity (Request -> Entity, Entity -> Response).
 * For API layer to keep entities internal.
 */
@Service
@RequiredArgsConstructor
public class ResourceDtoService {

    private final ResourceService resourceService;

    // Helper: Request DTO -> Entity
    private Resource toEntity(ResourceRequest request) {
        if (request == null) return null;
        Resource resource = new Resource();
        resource.setName(request.getName());
        resource.setDescription(request.getDescription());
        resource.setType(request.getType());
        resource.setCapacity(request.getCapacity());
        resource.setResourceGroupId(request.getResourceGroupId());
        return resource;
    }

    public ResourceResponse create(ResourceRequest request) {
        Resource entity = toEntity(request);
        Resource saved = resourceService.create(entity);
        return ResourceResponse.fromEntity(saved);
    }

    public Optional<ResourceResponse> getById(Long id) {
        return resourceService.getById(id)
                .map(ResourceResponse::fromEntity);
    }

    public Optional<ResourceResponse> getByName(String name) {
        return resourceService.getByName(name)
                .map(ResourceResponse::fromEntity);
    }
}