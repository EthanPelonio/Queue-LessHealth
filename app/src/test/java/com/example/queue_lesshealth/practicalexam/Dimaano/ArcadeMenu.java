package com.example.queue_lesshealth.practicalexam.Dimaano;

import java.util.Scanner;

public class ArcadeMenu {

    private int tokenCount;
    private int ticketCount;

    public ArcadeMenu() {
        tokenCount = 0;
        ticketCount = 0;
    }

    public void start(Scanner scanner) {

        int choice = 0;

        while (choice != 3) {

            displayMenu();

            choice = scanner.nextInt();

            if (choice == 1) {

                buyTokens();

            } else if (choice == 2) {

                claimPrize(scanner);

            } else if (choice == 3) {

                exitSystem();

            } else {

                System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public void displayMenu() {

        System.out.println();
        System.out.println("=================================");
        System.out.println("        ARCADE COUNTER");
        System.out.println("=================================");
        System.out.println("1. Buy Tokens");
        System.out.println("2. Claim Prize");
        System.out.println("3. Exit");
        System.out.println("=================================");
        System.out.print("Enter choice: ");
    }

    public void buyTokens() {

        System.out.println();
        System.out.println("===== BUY TOKENS =====");
        System.out.println("Tokens purchased successfully!");

        tokenCount++;
    }

    public void claimPrize(Scanner scanner) {

    }

    public void exitSystem() {

        System.out.println();
        System.out.println("Thank you for playing at the Arcade!");
        System.out.println("System shutting down...");
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArcadeMenu arcadeSystem = new ArcadeMenu();
        arcadeSystem.start(scanner);

        scanner.close();
    }
}