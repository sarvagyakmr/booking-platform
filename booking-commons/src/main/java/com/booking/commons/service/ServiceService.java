package com.booking.commons.service;

import com.booking.commons.repository.ServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service for Service entity (renamed from ServicesService for convention).
 * Methods: create, getById, getByResourceGroupId (adapted from spec 'by resource ID' to match entity ref).
 * Uses fully-qualified entity name to avoid ambiguous import with @Service.
 */
@Service
@RequiredArgsConstructor
public class ServiceService {

    private final ServiceRepository serviceRepository;

    public com.booking.commons.entity.Service create(com.booking.commons.entity.Service service) {
        return serviceRepository.save(service);
    }

    public Optional<com.booking.commons.entity.Service> getById(Long id) {
        return serviceRepository.findById(id);
    }

    public List<com.booking.commons.entity.Service> getByResourceGroupId(Long resourceGroupId) {
        // Simple filter; extend repo for production
        return serviceRepository.findAll().stream()
                .filter(s -> resourceGroupId.equals(s.getResourceGroupId()))
                .toList();
    }
}