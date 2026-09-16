package com.parcial.shipping;

public class PickupPointShipping implements ShippingStrategy {
    @Override
    public ShippingQuote calculate(ShippingRequest request) {
        double cost = 12.0 + (request.distanceKm() * 0.025);
        int days = 3 + (int) Math.ceil(request.distanceKm() / 500.0);
        return new ShippingQuote(getName(), cost, days, 0.0);
    }

    @Override
    public String getName() {
        return "Casillero / punto de recogida";
    }
}