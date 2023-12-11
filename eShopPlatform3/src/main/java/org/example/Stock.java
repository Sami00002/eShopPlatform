package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Stock implements Observable {
    private List<Observer> observers = new ArrayList<>();
    private Map<String, Product> stockProducts = new HashMap<>();

    public void addProduct(Product product) {
        stockProducts.put(product.getName(), product);
        notifyObservers(product);
    }

    public boolean checkStock(Product product) {
        return stockProducts.containsKey(product.getName());
    }

    public boolean checkStock(Product product, int quantity) {
        return stockProducts.containsKey(product.getName())
                && stockProducts.get(product.getName()) != null;
    }

    public void removeProduct(Product product) {
        stockProducts.remove(product.getName());
        notifyObservers(product);
    }

    public Product getProductByName(String productName) {
        return stockProducts.get(productName);
    }

    public void updateProduct(Product product) {
        if (stockProducts.containsKey(product.getName())) {
            stockProducts.put(product.getName(), product);
            notifyObservers(product);
        }
    }

    public List<Product> getStockProducts() {
        return new ArrayList<>(stockProducts.values());
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers(Object data) {
        for (Observer observer : observers) {
            observer.update(data);
        }
    }

    public void updateStockAfterPurchase(List<Product> products) {
        for (Product product : products) {
            if (stockProducts.containsKey(product.getName())) {
                stockProducts.get(product.getName()).setStock(
                        stockProducts.get(product.getName()).getStock() - 1
                );
            }
        }
    }

    public void updateStockAfterReturn(List<Product> returnedProducts) {
        for (Product returnedProduct : returnedProducts) {
            if (stockProducts.containsKey(returnedProduct.getName())) {
                stockProducts.get(returnedProduct.getName()).setStock(
                        stockProducts.get(returnedProduct.getName()).getStock() + 1
                );
            }
        }
    }
}
