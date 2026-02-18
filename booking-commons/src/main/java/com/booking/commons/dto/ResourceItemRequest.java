package com.booking.commons.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Request DTO for ResourceItem.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResourceItemRequest {
    private String name;
    private String description;
    private Long resourceId;  // ID ref
    private Integer quantityAvailable;
}