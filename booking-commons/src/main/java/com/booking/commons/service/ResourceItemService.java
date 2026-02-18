package com.booking.commons.service;

import com.booking.commons.entity.ResourceItem;
import com.booking.commons.repository.ResourceItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service for ResourceItem entity.
 * Methods: create, get all by resource ID (using ID ref).
 */
@Service
@RequiredArgsConstructor
public class ResourceItemService {

    private final ResourceItemRepository resourceItemRepository;

    public ResourceItem create(ResourceItem resourceItem) {
        return resourceItemRepository.save(resourceItem);
    }

    public List<ResourceItem> getAllByResourceId(Long resourceId) {
        // Simple filter impl; extend repo with derived query for production
        return resourceItemRepository.findAll().stream()
                .filter(item -> resourceId.equals(item.getResourceId()))
                .toList();
    }
}