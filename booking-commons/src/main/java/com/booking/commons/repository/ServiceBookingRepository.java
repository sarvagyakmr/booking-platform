package com.booking.commons.repository;

import com.booking.commons.entity.ServiceBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Repository for ServiceBooking entity - core for managing bookings in the platform.
 */
@Repository
public interface ServiceBookingRepository extends JpaRepository<ServiceBooking, Long> {
    // Example custom queries for availability/booking logic using ID refs
    List<ServiceBooking> findByServiceIdAndStartTimeBetween(Long serviceId, LocalDateTime start, LocalDateTime end);
}