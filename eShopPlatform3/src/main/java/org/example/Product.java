package org.example;

class Product {
    private String name;
    private double price;
    private int stock;
    private double discountPercent;
    private Promotion promotion;

    public Product(String name) {
        this.name = name;
        this.price = 0.0;
        this.stock = 0;
        this.discountPercent = 0.0;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(double discountPercent) {
        this.discountPercent = discountPercent;
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }
}
