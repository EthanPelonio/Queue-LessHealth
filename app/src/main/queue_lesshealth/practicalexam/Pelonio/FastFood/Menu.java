package com.example.queue_lesshealth.practicalexam.Pelonio;

import java.util.ArrayList;
import java.util.Scanner;

public class FastFood_Menu {

    private final ArrayList<String> itemNames = new ArrayList<>();
    private final ArrayList<Double> prices = new ArrayList<>();
    private final ArrayList<Integer> quantities = new ArrayList<>();

    public void run(Scanner scanner) {

        int choice = 0;

        while (choice != 3) {

            System.out.println();
            System.out.println("===== QUICKBITE FAST FOOD =====");
            System.out.println("1. Order Burger");
            System.out.println("2. Order Fries");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input.");
                scanner.nextLine();
                continue;
            }

            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    orderBurger(scanner);
                    break;

                case 2:
                    orderFries();
                    break;

                case 3:
                    System.out.println();
                    System.out.println("===== RECEIPT =====");
                    displayOrder();
                    System.out.println();
                    System.out.println("Thank you for ordering at QuickBite!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private void orderBurger(Scanner scanner) {

        System.out.println();
        System.out.println("===== BURGER OPTIONS =====");
        System.out.println("1. Combo - PHP 135");
        System.out.println("2. Solo  - PHP 85");
        System.out.print("Enter choice: ");

        if (!scanner.hasNextInt()) {
            System.out.println("Invalid choice.");
            scanner.nextLine();
            return;
        }

        int choice = scanner.nextInt();

        switch (choice) {

            case 1:
                addItem("Burger Combo", 135.00, 1);
                System.out.println("Burger Combo added.");
                break;

            case 2:
                addItem("Burger Solo", 85.00, 1);
                System.out.println("Burger Solo added.");
                break;

            default:
                System.out.println("Invalid burger option.");
        }
    }

    private void orderFries() {

        addItem("Fries", 50.00, 1);

        System.out.println("Fries added.");
    }

    private void addItem(
            String itemName,
            double price,
            int quantity) {

        itemNames.add(itemName);
        prices.add(price);
        quantities.add(quantity);
    }

    public void displayOrder() {

        if (itemNames.isEmpty()) {
            System.out.println("No items ordered.");
            return;
        }

        for (int i = 0; i < itemNames.size(); i++) {

            double itemTotal =
                    prices.get(i) * quantities.get(i);

            System.out.printf(
                    "%d. %s x%d - PHP %.2f%n",
                    i + 1,
                    itemNames.get(i),
                    quantities.get(i),
                    itemTotal
            );
        }

        System.out.println("--------------------------");
        System.out.printf(
                "TOTAL: PHP %.2f%n",
                calculateTotal()
        );
    }

    public double calculateTotal() {

        double total = 0;

        for (int i = 0; i < itemNames.size(); i++) {
            total += prices.get(i) * quantities.get(i);
        }

        return total;
    }

    public int getItemCount() {
        return itemNames.size();
    }
}