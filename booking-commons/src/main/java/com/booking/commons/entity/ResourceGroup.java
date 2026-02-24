package com.booking.commons.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Represents a group of resources (e.g., all tables in a restaurant section or chairs in a salon).
 * Extends BaseEntity. Other entities reference it by ID only (resourceGroupId) - no JPA relationships.
 */
@Entity
@Table(name = "resource_groups")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResourceGroup extends BaseEntity {

    private String name;

    private String description;

    // ID reference to the client who owns this resource group
    private Long clientId;

    // Can hold additional metadata; grouping of resources/items done via ID refs in services/bookings
}