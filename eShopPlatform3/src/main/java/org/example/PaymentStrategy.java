package org.example;

import java.util.List;

interface PaymentStrategy {
    void pay(List<Product> products, Stock stock);
}