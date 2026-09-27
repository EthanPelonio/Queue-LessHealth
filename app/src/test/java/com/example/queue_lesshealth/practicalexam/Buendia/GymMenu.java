package com.example.queue_lesshealth.practicalexam.Buendia;
import java.util.Scanner;

public class GymMenu {

    public void start(Scanner scanner) {

        boolean running = true;

        while (running) {
            System.out.println("\n=== GYM MENU ===");
            System.out.println("1. Enter Gym");
            System.out.println("2. Hire Trainer");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.println("You entered the gym.");
                System.out.println("Choose membership level:");
                System.out.println("1. Level 1");
                System.out.println("2. Level 2");

                int level = scanner.nextInt();

                if (level == 1) {
                    System.out.println("Level 1 membership selected.");
                    System.out.println("Trainer Assigned");

                } else if (level == 2) {
                    System.out.println("Level 2 membership selected.");
                    System.out.println("Upgrade Required");
                }

            } else if (choice == 2) {
                System.out.println("Trainer selected.");

            } else if (choice == 3) {
                System.out.println("Exiting gym system.");
                running = false;
            }
        }
    }
}

