package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClientConsoleInterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Bicycle eShop!");

        List<Product> watchList = new ArrayList<>();
        List<Order> orders = new ArrayList<>();
        Client client = new Client("Client1", new ArrayList<>(), new ArrayList<>());

        while (true) {
            System.out.println("1. View Products");
            System.out.println("2. Add to Cart");
            System.out.println("3. Apply Promotion");
            System.out.println("4. View Cart");
            System.out.println("5. Checkout");
            System.out.println("6. View Orders");
            System.out.println("7. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
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
                    System.out.println("Thank you for using the Bicycle eShop. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void viewProducts() {
        System.out.println("Product list: [Product1, Product2, ...]");
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
        System.out.println("Checkout process initiated for " + client.getName());
    }
}
