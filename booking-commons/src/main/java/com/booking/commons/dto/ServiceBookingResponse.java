package com.booking.commons.dto;

import com.booking.commons.entity.BookingStatus;
import com.booking.commons.entity.ServiceBooking;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Response DTO for ServiceBooking with mapper.
 * Includes status enum from entity.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceBookingResponse {
    private Long id;
    private Long serviceId;  // ID ref
    private Long resourceId;  // optional ID ref
    private String customerName;
    private String customerEmail;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private BookingStatus status;
    private Long version;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static ServiceBookingResponse fromEntity(ServiceBooking booking) {
        if (booking == null) return null;
        return new ServiceBookingResponse(
                booking.getId(),
                booking.getServiceId(),
                booking.getResourceId(),
                booking.getCustomerName(),
                booking.getCustomerEmail(),
                booking.getStartTime(),
                booking.getEndTime(),
                booking.getStatus(),
                booking.getVersion(),
                booking.getCreatedAt(),
                booking.getUpdatedAt()
        );
    }
}