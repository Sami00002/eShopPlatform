package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class BikeShopApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Bicycle eShop!");

        while (true) {
            System.out.println("name:seller1");
            System.out.println("password:password1");
            System.out.println("1. Login as Seller");
            System.out.println("2. Login as Client");
            System.out.println("3. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    Seller seller = SellerConsoleInterface.loginSeller(scanner);
                    if (seller != null) {
                        SellerConsoleInterface.manageSeller(seller, scanner);
                    }
                    break;
                case 2:
                    System.out.println("name:Clientq");
                    System.out.print("Enter your name: ");
                    String clientName = scanner.nextLine();
                    Client client = new Client(clientName, new ArrayList<>(), new ArrayList<>());

                    while (true) {
                        System.out.println("1. View Products");
                        System.out.println("2. Add to Cart");
                        System.out.println("3. Apply Promotion");
                        System.out.println("4. View Cart");
                        System.out.println("5. Checkout");
                        System.out.println("6. View Orders");
                        System.out.println("7. Logout");
                        System.out.print("Select an option: ");

                        int clientChoice = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character

                        switch (clientChoice) {
                            case 1:
                                viewProducts();
                                break;
                            case 2:
                                addToCart(client, scanner);
                                break;
                            case 3:
                                applyPromotion(client, scanner);
                                break;
                            case 4:
                                client.viewCart();
                                break;
                            case 5:
                                checkout(client, scanner);
                                break;
                            case 6:
                                client.viewOrders();
                                break;
                            case 7:
                                System.out.println("Logging out. Goodbye, " + client.getName() + "!");
                                return;
                            default:
                                System.out.println("Invalid option. Please try again.");
                        }
                    }
                case 3:
                    System.out.println("Thank you for using the Bicycle eShop. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void viewProducts() {
        // Replace this comment with your logic to display available products
        ProductServiceFacade productServiceFacade = new ProductServiceFacade(new Stock());
        productServiceFacade.viewStock();
    }

    private static void addToCart(Client client, Scanner scanner) {
        System.out.print("Enter product name to add to cart: ");
        String productName = scanner.nextLine();
        Product product = new Product(productName);
        client.addToCart(product);
        System.out.println("Product added to cart: " + product.getName());
    }

    private static void applyPromotion(Client client, Scanner scanner) {
        System.out.print("Enter product name to apply promotion: ");
        String productName = scanner.nextLine();
        Product product = new Product(productName);
        client.applyPromotion(product);
        System.out.println("Promotion applied to " + product.getName() + " in the cart.");
    }

    private static void checkout(Client client, Scanner scanner) {
        // Replace this comment with logic to initiate the checkout process
        System.out.println("Initiating the checkout process for " + client.getName() + "...");
    }
}