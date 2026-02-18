package com.booking.commons.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Represents a core resource in the booking platform (e.g., salon chair, restaurant table, or any bookable asset).
 * Extends BaseEntity for ID, version (optimistic locking), and audit fields.
 * Uses ID references only (no JPA relationships) for flexibility in concrete services.
 */
@Entity
@Table(name = "resources")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Resource extends BaseEntity {

    private String name;

    private String description;

    private String type;  // e.g., "room", "chair", "table"

    private Integer capacity;  // e.g., number of people/seats

    // ID reference only (to ResourceGroup) - enables add/remove in ResourceGroupService
    private Long resourceGroupId;
}