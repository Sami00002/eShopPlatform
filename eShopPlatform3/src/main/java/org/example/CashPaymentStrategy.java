package org.example;

import java.util.List;

class CashPaymentStrategy implements PaymentStrategy {
    public void pay(List<Product> products, Stock stock) {
        System.out.println("Payment completed with Cash.");

        for (Product product : products) {
            stock.removeProduct(product);
        }
    }
}