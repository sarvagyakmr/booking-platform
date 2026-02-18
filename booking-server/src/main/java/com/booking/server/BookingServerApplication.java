package com.booking.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Main Spring Boot application class for the booking platform server.
 * Configured to scan components, entities, and repositories from commons and server modules.
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.booking"})
@EntityScan(basePackages = {"com.booking"})
@EnableJpaRepositories(basePackages = {"com.booking"})
public class BookingServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookingServerApplication.class, args);
    }
}