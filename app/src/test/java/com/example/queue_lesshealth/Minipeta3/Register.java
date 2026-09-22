import java.util.Scanner;

import org.junit.Test;
public class Main {
@Test
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println("       QUEUE-LESS HEALTH");
        System.out.println("          REGISTRATION");
        System.out.println("=================================");

        // Get user's name
        System.out.print("Enter your full name: ");
        String fullName = scanner.nextLine();

        // Get username
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        // Check if username is empty
        while (username.trim().isEmpty()) {
            System.out.println("Username cannot be empty.");
            System.out.print("Enter username: ");
            username = scanner.nextLine();
        }

        // Get password
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        // Check password length
        while (password.length() < 6) {
            System.out.println("Password must be at least 6 characters.");
            System.out.print("Enter password: ");
            password = scanner.nextLine();
        }

        // Confirm password
        System.out.print("Confirm password: ");
        String confirmPassword = scanner.nextLine();

        // Check if passwords match
        while (!password.equals(confirmPassword)) {
            System.out.println("Passwords do not match.");
            System.out.print("Confirm password again: ");
            confirmPassword = scanner.nextLine();
        }

        // Get age
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
                scanner.next(); // Remove invalid input
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
        System.out.println("Welcome to Queue-Less Health, "
                + fullName + "!");
        System.out.println("=================================");

        scanner.close();
    }
}
