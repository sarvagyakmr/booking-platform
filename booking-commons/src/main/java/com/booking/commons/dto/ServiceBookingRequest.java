package com.booking.commons.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Request DTO for ServiceBooking.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceBookingRequest {
    private Long serviceId;  // ID ref
    private Long resourceId;  // optional ID ref
    private String customerName;
    private String customerEmail;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String status;  // e.g., "PENDING" - convert to enum
}