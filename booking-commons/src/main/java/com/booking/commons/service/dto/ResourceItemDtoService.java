package com.booking.commons.service.dto;

import com.booking.commons.dto.ResourceItemRequest;
import com.booking.commons.dto.ResourceItemResponse;
import com.booking.commons.entity.ResourceItem;
import com.booking.commons.service.ResourceItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * DTO service for ResourceItem - mirrors methods with Request/Response conversion.
 */
@Service
@RequiredArgsConstructor
public class ResourceItemDtoService {

    private final ResourceItemService resourceItemService;

    private ResourceItem toEntity(ResourceItemRequest request) {
        if (request == null) return null;
        ResourceItem item = new ResourceItem();
        item.setName(request.getName());
        item.setDescription(request.getDescription());
        item.setResourceId(request.getResourceId());
        item.setQuantityAvailable(request.getQuantityAvailable());
        item.setClientId(request.getClientId());
        return item;
    }

    public ResourceItemResponse create(ResourceItemRequest request) {
        ResourceItem entity = toEntity(request);
        ResourceItem saved = resourceItemService.create(entity);
        return ResourceItemResponse.fromEntity(saved);
    }

    public List<ResourceItemResponse> getAllByResourceId(Long resourceId, Long clientId) {
        return resourceItemService.getAllByResourceId(resourceId, clientId).stream()
                .map(ResourceItemResponse::fromEntity)
                .toList();
    }

    public Optional<ResourceItemResponse> getById(Long id, Long clientId) {
        return resourceItemService.getById(id, clientId)
                .map(ResourceItemResponse::fromEntity);
    }
}