package com.booking.commons.repository;

import com.booking.commons.entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for Service entity (tied to resource groups).
 */
@Repository
public interface ServiceRepository extends JpaRepository<Service, Long> {
    // Custom queries e.g., findByResourceGroupId
}