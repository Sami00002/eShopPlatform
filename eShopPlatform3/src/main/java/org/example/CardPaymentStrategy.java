package org.example;

import java.util.List;

class CardPaymentStrategy implements PaymentStrategy {
    public void pay(List<Product> products, Stock stock) {
        System.out.println("Payment completed with Card.");

        for (Product product : products) {
            stock.removeProduct(product);
        }
    }
}