package org.example;

class ProductServiceFacade {
    private Stock stock;

    public ProductServiceFacade(Stock stock) {
        this.stock = stock;
    }


    public void viewStock() {
        // Display the entire stock
        System.out.println("All Products in Stock - " + stock.getStockProducts());
    }
}