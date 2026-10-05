package com.example.queue_lesshealth.practicalexam.Dimaano;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        StringBuilder automatedInput = new StringBuilder();

        System.out.println("--- GENERATING ARCADE TEST DATA ---");

        // Step 1: Buy tokens option
        automatedInput.append("1\n");

        // Step 2: Test low ticket count for prize (< 500)
        automatedInput.append("2\n");
        automatedInput.append("200\n");

        // Step 3: Test high ticket count for prize (>= 500)
        automatedInput.append("2\n");
        automatedInput.append("600\n");

        // Step 4: Exit system
        automatedInput.append("3\n");

        System.out.println("--- TEST DATA GENERATION COMPLETE ---");
        System.out.println();

        ByteArrayInputStream inputStream =
                new ByteArrayInputStream(
                        automatedInput.toString().getBytes()
                );

        Scanner scanner = new Scanner(inputStream);

        ArcadeMenu arcadeSystem = new ArcadeMenu();
        arcadeSystem.start(scanner);

        scanner.close();
    }
}

class ArcadeMenu {

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

            switch (choice) {

                case 1:
                    buyTokens();
                    break;

                case 2:
                    claimPrize(scanner);
                    break;

                case 3:
                    exitSystem();
                    break;

                default:
                    System.out.println();
                    System.out.println("Invalid choice.");
                    System.out.println("Please select 1, 2, or 3.");
                    break;
            }
        }
    }

    public void displayMenu() {

        System.out.println();
        System.out.println("=================================");
        System.out.println("          ARCADE COUNTER");
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

        tokenCount++;

        System.out.println("Tokens purchased successfully!");
        System.out.println("Total token purchases: " + tokenCount);
    }

    public void claimPrize(Scanner scanner) {

        System.out.println();
        System.out.println("===== CLAIM PRIZE =====");
        System.out.print("Enter ticket count: ");

        ticketCount = scanner.nextInt();

        if (ticketCount >= 500) {

            System.out.println();
            System.out.println("Congratulations!");
            System.out.println("Teddy Bear Won");

        } else {

            System.out.println();
            System.out.println("Not enough tickets.");
            System.out.println("Keep Playing");
        }
    }

    public void exitSystem() {

