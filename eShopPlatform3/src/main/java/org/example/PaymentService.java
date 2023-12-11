package org.example;

import java.util.List;

class PaymentService {
    public void processPayment(Client client, List<Product> products, PaymentStrategy paymentStrategy, Stock stock) {
        paymentStrategy.pay(products, stock);
        System.out.println("Payment processed successfully for " + client.getName());
    }

}