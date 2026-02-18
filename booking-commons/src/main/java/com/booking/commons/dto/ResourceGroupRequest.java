package com.booking.commons.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Request DTO for ResourceGroup.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResourceGroupRequest {
    private String name;
    private String description;
}