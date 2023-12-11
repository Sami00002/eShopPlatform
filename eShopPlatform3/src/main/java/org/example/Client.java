package org.example;

import java.util.List;

public class Client {
    private String name;
    private Cart cart;
    private List<Order> orders;

    public Client(String name, List<Product> watchList, List<Order> orders) {
        this.name = name;
        this.cart = new Cart();
        this.orders = orders;
    }

    public void addToCart(Product product) {
        cart.addProduct(product);
        System.out.println(name + ": Added " + product.getName() + " to the cart.");
    }

    public void removeFromCart(Product product) {
        cart.removeFromCart(product);
    }

    public void applyPromotion(Product product) {
        cart.applyPromotion(product);
        System.out.println(name + ": Applied promotion to " + product.getName() + " in the cart.");
    }

    public void checkout(PaymentStrategy paymentStrategy, Stock stock) {
        cart.buy(paymentStrategy, this, stock);
        Order order = new Order(cart.getProducts());
        orders.add(order);
        System.out.println(name + ": Checkout completed.");
    }

    public void viewOrders() {
        System.out.println(name + ": Orders - " + orders);
    }

    public void viewCart() {
        System.out.println(name + ": Cart - " + cart.getProducts());
    }

    public Cart getCart() {
        return cart;
    }

    public String getName() {
        return name;
    }

}