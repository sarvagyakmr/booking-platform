package com.booking.commons.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * Request DTO for Service.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceRequest {
    private String name;
    private String description;
    private Integer durationMinutes;
    private BigDecimal price;
    private Long resourceGroupId;  // ID ref
}