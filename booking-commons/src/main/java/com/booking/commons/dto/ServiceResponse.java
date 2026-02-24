package com.booking.commons.dto;

import com.booking.commons.entity.Service;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Response DTO for Service with mapper.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceResponse {
    private Long id;
    private String name;
    private String description;
    private Integer durationMinutes;
    private BigDecimal price;
    private Long resourceGroupId;  // ID ref
    private Long version;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static ServiceResponse fromEntity(Service service) {
        if (service == null) return null;
        return new ServiceResponse(
                service.getId(),
                service.getName(),
                service.getDescription(),
                service.getDurationMinutes(),
                service.getPrice(),
                service.getResourceGroupId(),
                service.getVersion(),
                service.getCreatedAt(),
                service.getUpdatedAt()
        );
    }
}