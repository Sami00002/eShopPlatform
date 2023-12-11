package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Seller implements Observer {
    private String name;
    private String password;
    private Map<String, Product> products = new HashMap<>();
    private Stock stock;

    public Seller(String name, String password, Stock stock) {
        this.name = name;
        this.password = password;
        this.stock = stock;
        stock.addObserver(this);
    }

    public boolean login(String enteredPassword) {
        return enteredPassword.equals(password);
    }

    public void manageItems() {
        System.out.println(name + ": Managing items...");
    }

    public void addProduct(String productName, double price, int stock2, double discountPercent) {
        if (productName != null && !productName.isEmpty() && price > 0 && stock2 >= 0 && discountPercent >= 0) {
            Product product = new Product(productName);
            product.setPrice(price);
            product.setStock(stock2);
            product.setDiscountPercent(discountPercent);

            products.put(product.getName(), product);
            stock.addProduct(product); // Assuming stock is an instance of the Stock class
            System.out.println(name + ": Product added - " + product.getName());
        } else {
            System.out.println("Invalid product details. Please provide valid information.");
        }
    }

    public void updateProductDetails(Product product, double newPrice, int newStock, double newDiscountPercent) {
        if (products.containsKey(product.getName())) {
            product.setPrice(newPrice);
            product.setStock(newStock);
            product.setDiscountPercent(newDiscountPercent);

            products.put(product.getName(), product);
            stock.updateProduct(product);

            System.out.println(name + ": Product details updated - " + product.getName());
            System.out.println("New Price: " + newPrice);
            System.out.println("New Stock: " + newStock);
            System.out.println("New Discount Percent: " + newDiscountPercent);
        } else {
            System.out.println(name + ": Product not found - " + product.getName());
        }
    }

    public void configurePromotion(Product product, double discountPercent, int durationDays) {
        // Configuration logic for promotions
        Promotion promotion = new Promotion(product, discountPercent, durationDays);
        product.setPromotion(promotion);
        stock.updateProduct(product);
        System.out.println(name + ": Promotion configured for " + product.getName());
    }

    public void viewStockDetails() {
        // Display the seller's stock with details
        System.out.println(name + ": Seller's Stock - ");
        for (Product product : products.values()) {
            System.out.println("Name: " + product.getName() +
                    ", Price: " + product.getPrice() +
                    ", Stock: " + product.getStock() +
                    ", Discount Percent: " + product.getDiscountPercent());
            if (product.getPromotion() != null) {
                System.out.println("Promotion - Discount Percent: " +
                        product.getPromotion().getDiscountPercent() +
                        ", Duration Days: " + product.getPromotion().getDurationDays());
            }
        }
    }

    public String getName() {
        return name;
    }

    public Map<String, Product> getProducts() {
        return products;
    }

    public Product getProductByName(String productName) {
        return products.get(productName);
    }

    public void update(Object data) {
        if (data instanceof Product) {
            Product updatedProduct = (Product) data;
            // Update logic for seller when a product changes
            System.out.println(name + ": Product updated - " + updatedProduct.getName());
        }
    }
    // Other seller-related activities
}