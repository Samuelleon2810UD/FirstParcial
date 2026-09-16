package com.parcial;

import com.parcial.shipping.EconomicShipping;
import com.parcial.shipping.EcoShipping;
import com.parcial.shipping.ExpressShipping;
import com.parcial.shipping.Order;
import com.parcial.shipping.PickupPointShipping;
import com.parcial.shipping.ShippingRequest;
import com.parcial.shipping.ShippingStrategy;

public class Main {
    public static void main(String[] args) {
        ShippingRequest request = new ShippingRequest(
                "Madrid, España", 8_400, 3.5, 250.0);
        Order order = new Order("GM-1001", request, new EconomicShipping());

        System.out.println("Orden " + order.getOrderId());
        printQuote(order);

        System.out.println("\nCambio de modalidad en el checkout:");
        ShippingStrategy[] availableStrategies = {
                new ExpressShipping(),
                new EcoShipping(),
                new PickupPointShipping()
        };
        for (ShippingStrategy strategy : availableStrategies) {
            order.setShippingStrategy(strategy);
            printQuote(order);
        }
    }

    private static void printQuote(Order order) {
        System.out.println(order.calculateShipping());
    }
}