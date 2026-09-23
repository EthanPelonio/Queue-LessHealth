package com.example.queue_lesshealth.practicalexam.Pelonio;

import java.util.Scanner;

public class FastFood {

    private String customerName;
    private Order order;

    public FastFood() {
        customerName = "";
        order = new Order();
    }

    public void run(Scanner scanner) {

        int choice = 0;

        while (choice != 5) {

            System.out.println("\n===== QUICKBITE FAST FOOD =====");
            System.out.println("1. Register Customer");
            System.out.println("2. View Menu");
            System.out.println("3. Add Order");
            System.out.println("4. View Receipt");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

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
                    System.out.println("Thank you for ordering at QuickBite!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public void registerCustomer(Scanner scanner) {

        System.out.println("\n===== CUSTOMER REGISTRATION =====");

        scanner.nextLine();

        System.out.print("Enter customer name: ");
        customerName = scanner.nextLine();

        System.out.println("Customer registered successfully!");
    }

    public void displayMenu() {

        System.out.println("\n===== QUICKBITE MENU =====");
        System.out.println("1. Burger      - PHP 85");
        System.out.println("2. Fries       - PHP 50");
        System.out.println("3. Chicken     - PHP 120");
        System.out.println("4. Spaghetti   - PHP 75");
        System.out.println("5. Soda        - PHP 40");
    }

    public void addOrder(Scanner scanner) {

        displayMenu();

        System.out.print("\nEnter item number: ");
        int item = scanner.nextInt();

        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();

        if (quantity <= 0) {
            System.out.println("Quantity must be greater than zero.");
            return;
        }

        String itemName;
        double price;

        switch (item) {

            case 1:
                itemName = "Burger";
                price = 85;
                break;

            case 2:
                itemName = "Fries";
                price = 50;
                break;

            case 3:
                itemName = "Chicken";
                price = 120;
                break;

            case 4:
                itemName = "Spaghetti";
                price = 75;
                break;

            case 5:
                itemName = "Soda";
                price = 40;
                break;

            default:
                System.out.println("Invalid item.");
                return;
        }

        order.addItem(itemName, price, quantity);

        System.out.println(quantity + "x " + itemName + " added to your order.");
    }

    public void displayReceipt() {

        System.out.println("\n========== RECEIPT ==========");

        if (customerName.equals("")) {
            System.out.println("Customer: Guest");
        } else {
            System.out.println("Customer: " + customerName);
        }

        System.out.println("-----------------------------");

        order.displayItems();

        double subtotal = order.calculateSubtotal();
        double discount = calculateDiscount(subtotal);
        double total = subtotal - discount;

        System.out.println("-----------------------------");
        System.out.printf("Subtotal: PHP %.2f%n", subtotal);
        System.out.printf("Discount: PHP %.2f%n", discount);
        System.out.printf("TOTAL:    PHP %.2f%n", total);
        System.out.println("=============================");
    }

    public double calculateDiscount(double subtotal) {

        if (subtotal >= 500) {
            return subtotal * 0.10;
        } else {
            return 0;
        }
    }
}