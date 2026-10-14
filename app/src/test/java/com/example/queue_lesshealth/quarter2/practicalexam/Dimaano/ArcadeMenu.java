package com.example.queue_lesshealth.practicalexam.Dimaano;

import java.io.ByteArrayInputStream;
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

        System.out.println();
        System.out.println("=================================");
        System.out.println("     THANK YOU FOR PLAYING!");
        System.out.println("=================================");

    }
}