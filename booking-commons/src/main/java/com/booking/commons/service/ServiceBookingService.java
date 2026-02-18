package com.booking.commons.service;

import com.booking.commons.entity.ServiceBooking;
import com.booking.commons.repository.ServiceBookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service for ServiceBooking entity.
 * Methods: create, getById.
 * Core for booking operations in the platform.
 */
@Service
@RequiredArgsConstructor
public class ServiceBookingService {

    private final ServiceBookingRepository serviceBookingRepository;

    public ServiceBooking create(ServiceBooking booking) {
        return serviceBookingRepository.save(booking);
    }

    public Optional<ServiceBooking> getById(Long id) {
        return serviceBookingRepository.findById(id);
    }
}