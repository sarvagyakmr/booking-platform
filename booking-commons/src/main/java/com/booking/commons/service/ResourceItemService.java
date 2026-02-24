package com.booking.commons.service;

import com.booking.commons.entity.ResourceItem;
import com.booking.commons.exception.ClientIdMismatchException;
import com.booking.commons.repository.ResourceItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public List<ResourceItem> getAllByResourceId(Long resourceId, Long clientId) {
        // Simple filter impl; extend repo with derived query for production
        return resourceItemRepository.findAll().stream()
                .filter(item -> resourceId.equals(item.getResourceId()))
                .filter(item -> clientId.equals(item.getClientId()))
                .toList();
    }

    public Optional<ResourceItem> getById(Long id, Long clientId) {
        Optional<ResourceItem> itemOpt = resourceItemRepository.findById(id);
        if (itemOpt.isPresent()) {
            ResourceItem item = itemOpt.get();
            if (!item.getClientId().equals(clientId)) {
                throw new ClientIdMismatchException("Client ID does not match the resource item owner");
            }
        }
        return itemOpt;
    }
}