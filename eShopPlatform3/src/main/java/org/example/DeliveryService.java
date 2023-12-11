package org.example;

import java.util.List;

class DeliveryService {
    public void deliverOrder(Client client, List<Product> products, String deliveryMethod) {
        System.out.println("Order delivered to " + client.getName() + " via " + deliveryMethod);
    }
}
