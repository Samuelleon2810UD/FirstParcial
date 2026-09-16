package com.parcial.shipping;

public class EcoShipping implements ShippingStrategy {
    @Override
    public ShippingQuote calculate(ShippingRequest request) {
        double cost = 32.0 + (request.weightKg() * 1.10) + (request.distanceKm() * 0.045);
        int days = 10 + (int) Math.ceil(request.distanceKm() / 800.0);
        double carbon = request.weightKg() * request.distanceKm() * 0.03;
        return new ShippingQuote(getName(), cost, days, carbon);
    }

    @Override
    public String getName() {
        return "Ecológico (neutral en carbono)";
    }
}