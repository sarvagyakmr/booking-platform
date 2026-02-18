package com.booking.commons.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Represents an item or variant within a resource (e.g., equipment in a salon room or menu item at a table).
 * Extends BaseEntity. Uses ID reference (resourceId) only - no JPA @ManyToOne etc. for core flexibility.
 */
@Entity
@Table(name = "resource_items")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResourceItem extends BaseEntity {

    private String name;

    private String description;

    // ID reference only (to Resource)
    private Long resourceId;

    private Integer quantityAvailable;
}