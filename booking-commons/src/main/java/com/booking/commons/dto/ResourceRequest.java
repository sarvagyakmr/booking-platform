package com.booking.commons.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Request DTO for creating/updating Resource (excludes ID, version, audit fields from entity).
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResourceRequest {
    private String name;
    private String description;
    private String type;
    private Integer capacity;
    private Long resourceGroupId;  // ID ref
}