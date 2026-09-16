package com.parcial.shipping;

import java.util.Objects;

public class Order {
    private final String orderId;
    private final ShippingRequest shippingRequest;
    private ShippingStrategy shippingStrategy;

    public Order(String orderId, ShippingRequest shippingRequest, ShippingStrategy shippingStrategy) {
        this.orderId = Objects.requireNonNull(orderId, "orderId cannot be null");
        this.shippingRequest = Objects.requireNonNull(shippingRequest, "shippingRequest cannot be null");
        setShippingStrategy(shippingStrategy);
    }

    public void setShippingStrategy(ShippingStrategy shippingStrategy) {
        this.shippingStrategy = Objects.requireNonNull(shippingStrategy, "shippingStrategy cannot be null");
    }

    public ShippingQuote calculateShipping() {
        return shippingStrategy.calculate(shippingRequest);
    }

    public String getOrderId() {
        return orderId;
    }
}