package com.booking.commons.service;

import com.booking.commons.entity.Resource;
import com.booking.commons.exception.ClientIdMismatchException;
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

    public Optional<Resource> getById(Long id, Long clientId) {
        Optional<Resource> resourceOpt = resourceRepository.findById(id);
        if (resourceOpt.isPresent()) {
            Resource resource = resourceOpt.get();
            if (!resource.getClientId().equals(clientId)) {
                throw new ClientIdMismatchException("Client ID does not match the resource owner");
            }
        }
        return resourceOpt;
    }

    public Optional<Resource> getByName(String name, Long clientId) {
        Optional<Resource> resourceOpt = resourceRepository.findAll().stream()
                .filter(r -> r.getName().equalsIgnoreCase(name))
                .findFirst();
        if (resourceOpt.isPresent()) {
            Resource resource = resourceOpt.get();
            if (!resource.getClientId().equals(clientId)) {
                throw new ClientIdMismatchException("Client ID does not match the resource owner");
            }
        }
        return resourceOpt;
    }
}