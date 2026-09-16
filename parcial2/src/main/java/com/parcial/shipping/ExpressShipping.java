package com.parcial.shipping;

public class ExpressShipping implements ShippingStrategy {
    @Override
    public ShippingQuote calculate(ShippingRequest request) {
        double cost = 65.0 + (request.weightKg() * 4.50) + (request.distanceKm() * 0.12);
        int days = Math.max(1, (int) Math.ceil(request.distanceKm() / 2500.0));
        double carbon = request.weightKg() * request.distanceKm() * 0.60;
        return new ShippingQuote(getName(), cost, days, carbon);
    }

    @Override
    public String getName() {
        return "Express (aéreo)";
    }
}