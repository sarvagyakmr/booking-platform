package com.booking.commons.entity;

/**
 * Enum for booking status in ServiceBooking entity.
 * Simple status flow for the core booking platform.
 */
public enum BookingStatus {
    PENDING,
    CONFIRMED,
    CANCELLED,
    COMPLETED
}