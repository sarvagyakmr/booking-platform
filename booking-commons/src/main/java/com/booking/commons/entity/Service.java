package com.booking.commons.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * Represents a bookable service tied to a resource group (e.g., "haircut" for salon chairs group or "dinner" for restaurant tables).
 * Extends BaseEntity. References resourceGroupId by ID only - no JPA relationships.
 */
@Entity
@Table(name = "services")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Service extends BaseEntity {

    private String name;

    private String description;

    private Integer durationMinutes;  // e.g., service length in minutes

    private BigDecimal price;

    // ID reference only (to ResourceGroup)
    private Long resourceGroupId;
}