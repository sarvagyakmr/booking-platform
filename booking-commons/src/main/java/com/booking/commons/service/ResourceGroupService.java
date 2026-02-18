package com.booking.commons.service;

import com.booking.commons.entity.Resource;
import com.booking.commons.entity.ResourceGroup;
import com.booking.commons.repository.ResourceGroupRepository;
import com.booking.commons.repository.ResourceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service for ResourceGroup entity.
 * Methods: create, addResourceToGroup (sets ID ref), removeResourceFromGroup (clears ID ref), getAll.
 * Uses ID references only per design.
 */
@Service
@RequiredArgsConstructor
public class ResourceGroupService {

    private final ResourceGroupRepository resourceGroupRepository;
    private final ResourceRepository resourceRepository;

    public ResourceGroup create(ResourceGroup resourceGroup) {
        return resourceGroupRepository.save(resourceGroup);
    }

    public Resource addResourceToGroup(Long resourceId, Long groupId) {
        Optional<Resource> resourceOpt = resourceRepository.findById(resourceId);
        if (resourceOpt.isPresent()) {
            Resource resource = resourceOpt.get();
            resource.setResourceGroupId(groupId);
            return resourceRepository.save(resource);
        }
        throw new IllegalArgumentException("Resource not found");
    }

    public Resource removeResourceFromGroup(Long resourceId) {
        Optional<Resource> resourceOpt = resourceRepository.findById(resourceId);
        if (resourceOpt.isPresent()) {
            Resource resource = resourceOpt.get();
            resource.setResourceGroupId(null);
            return resourceRepository.save(resource);
        }
        throw new IllegalArgumentException("Resource not found");
    }

    public List<ResourceGroup> getAll() {
        return resourceGroupRepository.findAll();
    }
}