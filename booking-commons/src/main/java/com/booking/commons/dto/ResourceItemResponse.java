package com.booking.commons.dto;

import com.booking.commons.entity.ResourceItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Response DTO for ResourceItem with mapper.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResourceItemResponse {
    private Long id;
    private String name;
    private String description;
    private Long resourceId;  // ID ref
    private Integer quantityAvailable;
    private Long version;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static ResourceItemResponse fromEntity(ResourceItem item) {
        if (item == null) return null;
        return new ResourceItemResponse(
                item.getId(),
                item.getName(),
                item.getDescription(),
                item.getResourceId(),
                item.getQuantityAvailable(),
                item.getVersion(),
                item.getCreatedAt(),
                item.getUpdatedAt()
        );
    }
}