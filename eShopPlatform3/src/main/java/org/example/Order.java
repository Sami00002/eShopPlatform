package org.example;

import java.util.List;

public class Order {
    private static int orderNumberCounter = 1;
    private int orderNumber;
    private List<Product> products;

    public Order(List<Product> products) {
        this.products = products;
        this.orderNumber = orderNumberCounter++;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public List<Product> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNumber=" + orderNumber +
                ", products=" + products +
                '}';
    }
}
