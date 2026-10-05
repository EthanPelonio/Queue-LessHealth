package com.example.queue_lesshealth.practicalexam.Pelonio.FastFood;

import java.util.ArrayList;
import java.util.Scanner;

public class FastFood_Menu {

    // =========================
    // CUSTOMER AND ORDER DATA
    // =========================

    private String customerName;
    private final Order order;

    // =========================
    // CONSTRUCTOR
    // =========================

    public FastFood_Menu() {
        customerName = "Guest";
        order = new Order();
    }

    // =========================
    // MAIN MENU
    // =========================

    public void run(Scanner scanner) {

        int choice = 0;

        while (choice != 5) {

            System.out.println();
            System.out.println("=================================");
            System.out.println("       QUICKBITE FAST FOOD       ");
            System.out.println("=================================");
            System.out.println("1. Register Customer");
            System.out.println("2. View Menu");
            System.out.println("3. Add Order");
            System.out.println("4. View Receipt");
            System.out.println("5. Exit");
            System.out.println("=================================");
            System.out.print("Enter choice: ");

            // Check if input is an integer
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
                continue;
            }

            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    registerCustomer(scanner);
                    break;

                case 2:
                    displayMenu();
                    break;

                case 3:
                    addOrder(scanner);
                    break;

                case 4:
                    displayReceipt();
                    break;

                case 5:
                    System.out.println();
                    System.out.println("Thank you for ordering at QuickBite!");
                    System.out.println("Have a nice day!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    // =========================
    // REGISTER CUSTOMER
    // =========================

    public void registerCustomer(Scanner scanner) {

        System.out.println();
        System.out.println("===== CUSTOMER REGISTRATION =====");

        // Clear leftover newline
        scanner.nextLine();

        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();

        if (name.trim().isEmpty()) {
            customerName = "Guest";
        } else {
            customerName = name.trim();
        }

        System.out.println("Customer registered successfully!");
        System.out.println("Customer: " + customerName);
    }

    // =========================
    // DISPLAY MENU
    // =========================

    public void displayMenu() {

        System.out.println();
        System.out.println("========== QUICKBITE MENU ==========");
        System.out.println("1. Burger       - PHP 85.00");
        System.out.println("2. Fries        - PHP 50.00");
        System.out.println("3. Chicken      - PHP 120.00");
        System.out.println("4. Spaghetti    - PHP 75.00");
        System.out.println("5. Soda          - PHP 40.00");
        System.out.println("====================================");
    }

    // =========================
    // ADD ORDER
    // =========================

    public void addOrder(Scanner scanner) {

        displayMenu();

        System.out.print("Enter item number: ");

        if (!scanner.hasNextInt()) {
            System.out.println("Invalid item number.");
            scanner.nextLine();
            return;
        }

        int item = scanner.nextInt();

        String itemName;
        double price;

        switch (item) {

            case 1:
                itemName = "Burger";
                price = 85.00;
                break;

            case 2:
                itemName = "Fries";
                price = 50.00;
                break;

            case 3:
                itemName = "Chicken";
                price = 120.00;
                break;

            case 4:
                itemName = "Spaghetti";
                price = 75.00;
                break;

            case 5:
                itemName = "Soda";
                price = 40.00;
                break;

            default:
                System.out.println("Invalid item number.");
                return;
        }

        System.out.print("Enter quantity: ");

        if (!scanner.hasNextInt()) {
            System.out.println("Invalid quantity.");
            scanner.nextLine();
            return;
        }

        int quantity = scanner.nextInt();

        if (quantity <= 0) {
            System.out.println("Quantity must be greater than zero.");
            return;
        }

        // Add item to order
        order.addItem(itemName, price, quantity);

        System.out.println();
        System.out.println(quantity + "x " + itemName
                + " added to your order successfully!");
    }

    // =========================
    // DISPLAY RECEIPT
    // =========================

    public void displayReceipt() {

        System.out.println();
        System.out.println("=================================");
        System.out.println("             RECEIPT             ");
        System.out.println("=================================");

        System.out.println("Customer: " + customerName);

        System.out.println("---------------------------------");

        if (order.isEmpty()) {
            System.out.println("No items in the order.");
            System.out.println("---------------------------------");
            System.out.println("Subtotal: PHP 0.00");
            System.out.println("Discount: PHP 0.00");
            System.out.println("TOTAL:    PHP 0.00");
            System.out.println("=================================");
            return;
        }

        order.displayItems();

        double subtotal = order.calculateSubtotal();
        double discount = calculateDiscount(subtotal);
        double total = subtotal - discount;

        System.out.println("---------------------------------");
        System.out.printf("Subtotal: PHP %.2f%n", subtotal);
        System.out.printf("Discount: PHP %.2f%n", discount);
        System.out.printf("TOTAL:    PHP %.2f%n", total);
        System.out.println("=================================");
    }

    // =========================
    // CALCULATE DISCOUNT
    // =========================

    public double calculateDiscount(double subtotal) {

        // 10% discount if subtotal is PHP 500 or more
        if (subtotal >= 500.00) {
            return subtotal * 0.10;
        }

        return 0.00;
    }

    // =========================
    // ORDER CLASS
    // =========================

    private static class Order {

        private final ArrayList<OrderItem> items;

        public Order() {
            items = new ArrayList<>();
        }

        // Add item to order
        public void addItem(String itemName, double price, int quantity) {

            // Check if item already exists
            for (OrderItem item : items) {

                if (item.getItemName().equalsIgnoreCase(itemName)) {

                    item.setQuantity(
                            item.getQuantity() + quantity
                    );

                    return;
                }
            }

            // Add new item
            items.add(
                    new OrderItem(itemName, price, quantity)
            );
        }

        // Calculate subtotal
        public double calculateSubtotal() {

            double subtotal = 0.00;

            for (OrderItem item : items) {

                subtotal += item.getPrice()
                        * item.getQuantity();
            }

            return subtotal;
        }

        // Display all ordered items
        public void displayItems() {

            if (items.isEmpty()) {
                System.out.println("No items ordered.");
                return;
            }

            for (OrderItem item : items) {

                double itemTotal =
                        item.getPrice() * item.getQuantity();

                System.out.printf(
                        "%-12s %2dx PHP %.2f = PHP %.2f%n",
                        item.getItemName(),
                        item.getQuantity(),
                        item.getPrice(),
                        itemTotal
                );
            }
        }

        // Check if order is empty
        public boolean isEmpty() {
            return items.isEmpty();
        }
    }

    // =========================
    // ORDER ITEM CLASS
    // =========================

    private static class OrderItem {

        private final String itemName;
        private final double price;
        private int quantity;

        public OrderItem(
                String itemName,
                double price,
                int quantity
        ) {
            this.itemName = itemName;
            this.price = price;
            this.quantity = quantity;
        }

        public String getItemName() {
            return itemName;
        }

        public double getPrice() {
            return price;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
    }

    // =========================
    // MAIN METHOD
    // =========================

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        FastFood_Menu menu = new FastFood_Menu();

        menu.run(scanner);

        scanner.close();
    }
}