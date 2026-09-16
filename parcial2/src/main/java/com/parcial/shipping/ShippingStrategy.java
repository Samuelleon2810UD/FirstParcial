package com.parcial.shipping;

public interface ShippingStrategy {
    ShippingQuote calculate(ShippingRequest request);

    String getName();
}