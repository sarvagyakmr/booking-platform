package com.booking.commons.service.dto;

import com.booking.commons.dto.ServiceBookingRequest;
import com.booking.commons.dto.ServiceBookingResponse;
import com.booking.commons.entity.ServiceBooking;
import com.booking.commons.service.ServiceBookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * DTO service for ServiceBooking - mirrors methods with Request/Response conversion.
 * Handles status string to enum conversion.
 */
@Service
@RequiredArgsConstructor
public class ServiceBookingDtoService {

    private final ServiceBookingService serviceBookingService;

    private ServiceBooking toEntity(ServiceBookingRequest request) {
        if (request == null) return null;
        ServiceBooking booking = new ServiceBooking();
        booking.setServiceId(request.getServiceId());
        booking.setResourceId(request.getResourceId());
        booking.setCustomerName(request.getCustomerName());
        booking.setCustomerEmail(request.getCustomerEmail());
        booking.setStartTime(request.getStartTime());
        booking.setEndTime(request.getEndTime());
        // Simple string to enum; enhance with try/catch or map in production
        if (request.getStatus() != null) {
            booking.setStatus(com.booking.commons.entity.BookingStatus.valueOf(request.getStatus().toUpperCase()));
        }
        return booking;
    }

    public ServiceBookingResponse create(ServiceBookingRequest request) {
        ServiceBooking entity = toEntity(request);
        ServiceBooking saved = serviceBookingService.create(entity);
        return ServiceBookingResponse.fromEntity(saved);
    }

    public Optional<ServiceBookingResponse> getById(Long id) {
        return serviceBookingService.getById(id)
                .map(ServiceBookingResponse::fromEntity);
    }
}