package com.booking.commons.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Simple health check controller shared across booking services.
 * Provides a basic endpoint to verify the application is running.
 * Placed in commons for reusability in derived booking platforms (e.g., salon, restaurant).
 */
@RestController
@RequestMapping("/api")
public class HealthController {

    /**
     * Health check endpoint.
     * Returns HTTP 200 with "OK" body if the service is up.
     */
    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("OK");
    }
}