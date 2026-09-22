package com.example.queue_lesshealth.Minipeta3;

import java.util.Scanner;

public class AppointmentRequest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== APPOINTMENT REQUEST SYSTEM ===");

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your contact number: ");
        String contact = scanner.nextLine();

        System.out.print("Enter appointment date (MM/DD/YYYY): ");
        String date = scanner.nextLine();

        System.out.print("Enter appointment time: ");
        String time = scanner.nextLine();

        System.out.print("Enter purpose of appointment: ");
        String purpose = scanner.nextLine();

        System.out.println("\n=== APPOINTMENT REQUEST ===");
        System.out.println("Name: " + name);
        System.out.println("Contact: " + contact);
        System.out.println("Date: " + date);
        System.out.println("Time: " + time);
        System.out.println("Purpose: " + purpose);
        System.out.println("Status: REQUESTED");

        System.out.println("\nYour appointment request has been submitted.");

        scanner.close();
    }
}
