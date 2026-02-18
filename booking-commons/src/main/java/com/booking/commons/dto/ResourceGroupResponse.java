package com.booking.commons.dto;

import com.booking.commons.entity.ResourceGroup;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Response DTO for ResourceGroup with mapper.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResourceGroupResponse {
    private Long id;
    private String name;
    private String description;
    private Long version;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static ResourceGroupResponse fromEntity(ResourceGroup group) {
        if (group == null) return null;
        return new ResourceGroupResponse(
                group.getId(),
                group.getName(),
                group.getDescription(),
                group.getVersion(),
                group.getCreatedAt(),
                group.getUpdatedAt()
        );
    }
}