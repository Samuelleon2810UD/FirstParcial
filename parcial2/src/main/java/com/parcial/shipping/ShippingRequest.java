package com.parcial.shipping;

import java.util.Objects;

public record ShippingRequest(
        String destination,
        double distanceKm,
        double weightKg,
        double declaredValue) {

    public ShippingRequest {
        destination = Objects.requireNonNull(destination, "destination cannot be null").trim();
        if (destination.isEmpty()) {
            throw new IllegalArgumentException("destination cannot be empty");
        }
        if (distanceKm < 0 || weightKg <= 0 || declaredValue < 0) {
            throw new IllegalArgumentException("distance, weight and declared value must be valid");
        }
    }
}