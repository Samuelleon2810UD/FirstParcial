package com.parcial.shipping;

public record ShippingQuote(
        String method,
        double cost,
        int deliveryDays,
        double carbonKg) {

    public ShippingQuote {
        if (cost < 0 || deliveryDays < 0 || carbonKg < 0) {
            throw new IllegalArgumentException("quote values cannot be negative");
        }
    }

    @Override
    public String toString() {
        return "%s | costo: $%.2f | entrega: %d días | CO2: %.2f kg"
                .formatted(method, cost, deliveryDays, carbonKg);
    }
}