package com.booking.commons.repository;

import com.booking.commons.entity.Resource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for Resource entity.
 */
@Repository
public interface ResourceRepository extends JpaRepository<Resource, Long> {
    // Add custom queries as needed for booking logic, e.g., findByType
}