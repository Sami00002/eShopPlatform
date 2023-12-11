package org.example;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Product added to the cart: " + product.getName());
    }

    public void removeFromCart(Product product) {
        products.remove(product);
        System.out.println("Product removed from the cart: " + product.getName());
    }

    public void applyPromotion(Product product) {
        if (product.getPromotion() != null) {
            double discountedPrice = product.getPrice() * (1 - product.getPromotion().getDiscountPercent() / 100);
            product.setPrice(discountedPrice);
            System.out.println("Promotion applied to " + product.getName() + " in the cart.");
        }
    }

    public void buy(PaymentStrategy paymentStrategy, Client client, Stock stock) {
        paymentStrategy.pay(products, stock);
        System.out.println(client.getName() + ": Checkout successful!");
        products.clear();
    }

    public List<Product> getProducts() {
        return products;
    }

}