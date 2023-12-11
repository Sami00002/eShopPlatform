package org.example;

import java.util.List;

class LoanPaymentStrategy implements PaymentStrategy {
    public void pay(List<Product> products, Stock stock) {
        System.out.println("Payment completed with Loan.");

        for (Product product : products) {
            stock.removeProduct(product);
        }
    }

}