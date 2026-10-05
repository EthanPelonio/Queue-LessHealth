package com.example.queue_lesshealth.Minipeta3;


import java.util.ArrayList;
import java.util.Scanner;

public class Register {

    public static MainMenu.User registerUser(
            ArrayList<MainMenu.User> users) {

        Scanner sc = new Scanner(System.in);

        System.out.println("\n=================================");
        System.out.println("             REGISTER");
        System.out.println("=================================");

        System.out.print("Full Name: ");
        String name = sc.nextLine();

        System.out.print("Username: ");
        String username = sc.nextLine();

        for (MainMenu.User user : users) {

            if (user.username.equalsIgnoreCase(username)) {

                System.out.println(
                        "\nUsername already exists."
                );

                return null;
            }
        }

        System.out.print("Password: ");
        String password = sc.nextLine();

        System.out.print("Age: ");
        int age = Integer.parseInt(sc.nextLine());

        System.out.print("Contact Number: ");
        String contact = sc.nextLine();

        MainMenu.User newUser = new MainMenu.User(
                name,
                username,
                password,
                age,
                contact
        );

        users.add(newUser);

        System.out.println("\n=================================");
        System.out.println("      REGISTRATION SUCCESSFUL");
        System.out.println("=================================");
        System.out.println(
                "Welcome, " + name + "!"
        );

        return newUser;
    }
}