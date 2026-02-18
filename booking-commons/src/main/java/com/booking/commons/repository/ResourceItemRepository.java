package com.booking.commons.repository;

import com.booking.commons.entity.ResourceItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for ResourceItem entity.
 */
@Repository
public interface ResourceItemRepository extends JpaRepository<ResourceItem, Long> {
    // Custom queries e.g., findByResourceId
}