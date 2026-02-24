package com.booking.commons.repository;

import com.booking.commons.entity.ResourceGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for ResourceGroup entity.
 */
@Repository
public interface ResourceGroupRepository extends JpaRepository<ResourceGroup, Long> {
    // Custom queries e.g., findByName
}