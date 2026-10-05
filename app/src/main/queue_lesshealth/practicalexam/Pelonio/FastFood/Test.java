package com.example.FastFood.quarter2.practicalexam;
import com.example.queue_lesshealth.practicalexam.Pelonio.Order;

import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.util.Scanner;
public class FastFoodTest {
    @Test
    public void testFastFoodFlow() {
        StringBuilder automatedInput = new StringBuilder();
        System.out.println("--- GENERATING FAST FOOD TEST DATA ---");
// Step 1: Order Burger as Combo (Nested option 1)
        automatedInput.append("1\n"); // Choose Order Burger
        automatedInput.append("1\n"); // Choose Combo upgrade
// Step 2: Order Burger as Solo (Nested option 2)
        automatedInput.append("1\n"); // Choose Order Burger
        automatedInput.append("2\n"); // Choose Solo
// Step 3: Order Fries option
        automatedInput.append("2\n"); // Choose Order Fries
// Step 4: Exit system
        automatedInput.append("3\n"); // Choose Exit
        System.out.println("--- TEST DATA GENERATION COMPLETE ---\n");
        ByteArrayInputStream inputStream = new ByteArrayInputStream(automatedInput.toString().getBytes());
        Scanner scanner = new Scanner(inputStream);
    }
}
package com.example.queue_lesshealth.practicalexam.Pelonio;

import java.util.Scanner;

public class FastFood_Menu {

    private String customerName;
    private Order order;

    public FastFood_Menu() {
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