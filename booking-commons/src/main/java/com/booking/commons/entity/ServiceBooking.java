package com.booking.commons.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * Represents a booking for a service (e.g., salon appointment or restaurant reservation).
 * Extends BaseEntity. References serviceId (and optionally resource) by ID only - no JPA relationships.
 * Core for any booking service.
 */
@Entity
@Table(name = "service_bookings")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ServiceBooking extends BaseEntity {

    // ID reference only (to Service)
    private Long serviceId;

    // Optional ID ref (e.g., to Resource or ResourceItem for specific allocation)
    private Long resourceId;

    private String customerName;

    private String customerEmail;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    @Enumerated(EnumType.STRING)
    private BookingStatus status;  // e.g., PENDING, CONFIRMED, CANCELLED
}