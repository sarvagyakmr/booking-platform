package com.booking.commons.service.dto;

import com.booking.commons.dto.ServiceRequest;
import com.booking.commons.dto.ServiceResponse;
import com.booking.commons.service.ServiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * DTO service for Service - mirrors ServiceService methods with Request/Response conversion.
 * Uses FQ entity name to avoid ambiguity with @Service.
 */
@Service
@RequiredArgsConstructor
public class ServiceDtoService {

    private final ServiceService serviceService;

    private com.booking.commons.entity.Service toEntity(ServiceRequest request) {
        if (request == null) return null;
        com.booking.commons.entity.Service service = new com.booking.commons.entity.Service();
        service.setName(request.getName());
        service.setDescription(request.getDescription());
        service.setDurationMinutes(request.getDurationMinutes());
        service.setPrice(request.getPrice());
        service.setResourceGroupId(request.getResourceGroupId());
        return service;
    }

    public ServiceResponse create(ServiceRequest request) {
        com.booking.commons.entity.Service entity = toEntity(request);
        com.booking.commons.entity.Service saved = serviceService.create(entity);
        return ServiceResponse.fromEntity(saved);
    }

    public Optional<ServiceResponse> getById(Long id) {
        return serviceService.getById(id)
                .map(ServiceResponse::fromEntity);
    }

    public List<ServiceResponse> getByResourceGroupId(Long resourceGroupId) {
        return serviceService.getByResourceGroupId(resourceGroupId).stream()
                .map(ServiceResponse::fromEntity)
                .toList();
    }
}