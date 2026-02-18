package com.booking.commons.dto;

import com.booking.commons.entity.Resource;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Response DTO for Resource (includes all entity fields + ID/audit for API output).
 * Includes static mapper for easy conversion from entity.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResourceResponse {
    private Long id;
    private String name;
    private String description;
    private String type;
    private Integer capacity;
    private Long resourceGroupId;  // ID ref
    private Long version;  // from BaseEntity
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static ResourceResponse fromEntity(Resource resource) {
        if (resource == null) return null;
        return new ResourceResponse(
                resource.getId(),
                resource.getName(),
                resource.getDescription(),
                resource.getType(),
                resource.getCapacity(),
                resource.getResourceGroupId(),
                resource.getVersion(),
                resource.getCreatedAt(),
                resource.getUpdatedAt()
        );
    }
}