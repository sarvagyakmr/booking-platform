package com.booking.commons.service;

import com.booking.commons.entity.ServiceBooking;
import com.booking.commons.exception.ClientIdMismatchException;
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

    public Optional<ServiceBooking> getById(Long id, Long clientId) {
        Optional<ServiceBooking> bookingOpt = serviceBookingRepository.findById(id);
        if (bookingOpt.isPresent()) {
            ServiceBooking booking = bookingOpt.get();
            if (!booking.getClientId().equals(clientId)) {
                throw new ClientIdMismatchException("Client ID does not match the booking owner");
            }
        }
        return bookingOpt;
    }
}