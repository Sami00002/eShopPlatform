package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SellerConsoleInterface {
    private static final Map<String, Seller> SELLERS = new HashMap<>();

    static {
        SELLERS.put("seller1", new Seller("seller1", "password1", new Stock()));
        SELLERS.put("seller2", new Seller("seller2", "password2", new Stock()));
    }

    public static Seller loginSeller(Scanner scanner) {
        System.out.print("Enter seller username: ");
        String username = scanner.nextLine();
        System.out.print("Enter seller password: ");
        String password = scanner.nextLine();

        Seller seller = SELLERS.get(username);

        if (seller != null && seller.login(password)) {
            // Successful login
            System.out.println("Login successful! Welcome, " + username + ".");
            return seller;
        } else {
            // Failed login
            System.out.println("Login failed. Invalid username or password.");
            return null;
        }
    }

    public static void manageSeller(Seller seller, Scanner scanner) {
        while (true) {
            System.out.println("1. Manage Products");
            System.out.println("2. View Stock");
            System.out.println("3. Logout");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    manageProducts(seller, scanner);
                    break;
                case 2:
                    seller.viewStockDetails();
                    break;
                case 3:
                    System.out.println("Logging out. Goodbye, " + seller.getName() + "!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void manageProducts(Seller seller, Scanner scanner) {
        System.out.println("Managing Products");

        while (true) {
            System.out.println("1. Add Product");
            System.out.println("2. Update Product Details");
            System.out.println("3. Configure Promotion");
            System.out.println("4. Back to Seller Menu");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addProduct(seller, scanner);
                    break;
                case 2:
                    updateProductDetails(seller, scanner);
                    break;
                case 3:
                    configurePromotion(seller, scanner);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void addProduct(Seller seller, Scanner scanner) {
        System.out.print("Enter product name: ");
        String productName = scanner.nextLine();

        System.out.print("Enter product price: ");
        double price = scanner.nextDouble();

        System.out.print("Enter product stock: ");
        int stock = scanner.nextInt();

        System.out.print("Enter product discount percent: ");
        double discountPercent = scanner.nextDouble();

        seller.addProduct(productName, price, stock, discountPercent);
        System.out.println("Product added successfully: " + productName);
    }

    private static void updateProductDetails(Seller seller, Scanner scanner) {
        System.out.print("Enter product name to update details: ");
        String productName = scanner.nextLine();

        Product product = seller.getProductByName(productName);
        if (product != null) {
            System.out.print("Enter new price: ");
            double newPrice = scanner.nextDouble();

            System.out.print("Enter new stock: ");
            int newStock = scanner.nextInt();

            System.out.print("Enter new discount percent: ");
            double newDiscountPercent = scanner.nextDouble();

            seller.updateProductDetails(product, newPrice, newStock, newDiscountPercent);
            System.out.println("Product details updated successfully: " + productName);
        } else {
            System.out.println("Product not found: " + productName);
        }
    }

    private static void configurePromotion(Seller seller, Scanner scanner) {
        System.out.print("Enter product name to configure promotion: ");
        String productName = scanner.nextLine();

        Product product = seller.getProductByName(productName);
        if (product != null) {
            System.out.print("Enter promotion discount percent: ");
            double discountPercent = scanner.nextDouble();

            System.out.print("Enter promotion duration in days: ");
            int durationDays = scanner.nextInt();

            seller.configurePromotion(product, discountPercent, durationDays);
            System.out.println("Promotion configured successfully for " + productName);
        } else {
            System.out.println("Product not found: " + productName);
        }
    }
}