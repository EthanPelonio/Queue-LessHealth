package com.example.queue_lesshealth.Minipeta3;

import java.io.ByteArrayInputStream;
import java.util.Scanner;
import org.junit.Test;

public class Register {

    @Test
    public void testRegistration() {
        // Simulate automated user typing (FullName \n Username \n Password \n ConfirmPassword \n Age)
        String simulatedInput = "John Doe\njohndoe\nsecret123\nsecret123\n25\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        Scanner scanner = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println("       QUEUE-LESS HEALTH");
        System.out.println("          REGISTRATION");
        System.out.println("=================================");

        System.out.print("Enter your full name: ");
        String fullName = scanner.nextLine();

        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        while (username.trim().isEmpty()) {
            System.out.println("Username cannot be empty.");
            System.out.print("Enter username: ");
            username = scanner.nextLine();
        }

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        while (password.length() < 6) {
            System.out.println("Password must be at least 6 characters.");
            System.out.print("Enter password: ");
            password = scanner.nextLine();
        }

        System.out.print("Confirm password: ");
        String confirmPassword = scanner.nextLine();

        while (!password.equals(confirmPassword)) {
            System.out.println("Passwords do not match.");
            System.out.print("Confirm password again: ");
            confirmPassword = scanner.nextLine();
        }

        int age;
        while (true) {
            System.out.print("Enter your age: ");

            if (scanner.hasNextInt()) {
                age = scanner.nextInt();

                if (age > 0 && age <= 120) {
                    break;
                } else {
                    System.out.println("Please enter a valid age.");
                }
            } else {
                System.out.println("Please enter a number.");
                scanner.next();
            }
        }

        System.out.println();
        System.out.println("=================================");
        System.out.println("     REGISTRATION SUCCESSFUL!");
        System.out.println("=================================");
        System.out.println("Name     : " + fullName);
        System.out.println("Username : " + username);
        System.out.println("Age      : " + age);
        System.out.println("=================================");
        System.out.println("Welcome to Queue-Less Health, " + fullName + "!");
        System.out.println("=================================");

        scanner.close();
    }
}