package com.parcial.shipping;

public class EconomicShipping implements ShippingStrategy {
    @Override
    public ShippingQuote calculate(ShippingRequest request) {
        double cost = 18.0 + (request.weightKg() * 0.35) + (request.distanceKm() * 0.015);
        int days = 25 + (int) Math.ceil(request.distanceKm() / 1000.0);
        double carbon = request.weightKg() * request.distanceKm() * 0.18;
        return new ShippingQuote(getName(), cost, days, carbon);
    }

    @Override
    public String getName() {
        return "Económico (marítimo)";
    }
}