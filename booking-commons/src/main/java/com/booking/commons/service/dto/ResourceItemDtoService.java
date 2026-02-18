package com.booking.commons.service.dto;

import com.booking.commons.dto.ResourceItemRequest;
import com.booking.commons.dto.ResourceItemResponse;
import com.booking.commons.entity.ResourceItem;
import com.booking.commons.service.ResourceItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return item;
    }

    public ResourceItemResponse create(ResourceItemRequest request) {
        ResourceItem entity = toEntity(request);
        ResourceItem saved = resourceItemService.create(entity);
        return ResourceItemResponse.fromEntity(saved);
    }

    public List<ResourceItemResponse> getAllByResourceId(Long resourceId) {
        return resourceItemService.getAllByResourceId(resourceId).stream()
                .map(ResourceItemResponse::fromEntity)
                .toList();
    }
}