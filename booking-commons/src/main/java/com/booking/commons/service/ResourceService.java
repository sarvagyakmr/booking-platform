package com.booking.commons.service;

import com.booking.commons.entity.Resource;
import com.booking.commons.repository.ResourceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service for Resource entity.
 * Methods: create, get by ID, get by name.
 * Part of core booking platform services.
 */
@Service
@RequiredArgsConstructor
public class ResourceService {

    private final ResourceRepository resourceRepository;

    public Resource create(Resource resource) {
        return resourceRepository.save(resource);
    }

    public Optional<Resource> getById(Long id) {
        return resourceRepository.findById(id);
    }

    public Optional<Resource> getByName(String name) {
        // Simple impl using derived query or filter; extend repo for production
        return resourceRepository.findAll().stream()
                .filter(r -> r.getName().equalsIgnoreCase(name))
                .findFirst();
    }
}