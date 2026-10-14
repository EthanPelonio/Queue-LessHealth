package com.example.queue_lesshealth.Minipeta3;

import java.util.Scanner;

 class AppointmentRequest {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("====================================");
        System.out.println("       QUEUELESS HEALTH CLINIC");
        System.out.println("         APPOINTMENT REQUEST");
        System.out.println("====================================");

        System.out.print("Patient Name: ");
        String name = input.nextLine();

        System.out.print("Contact Number: ");
        String contact = input.nextLine();

        System.out.print("Appointment Date: ");
        String date = input.nextLine();

        System.out.print("Preferred Time: ");
        String time = input.nextLine();

        System.out.println();
        System.out.println("Choose Reason for Appointment:");
        System.out.println("1. General Check-up");
        System.out.println("2. Consultation");
        System.out.println("3. Dental Check-up");
        System.out.println("4. Laboratory Test");

        System.out.print("Enter choice: ");
        int choice = input.nextInt();

        String reason;

        if (choice == 1) {
            reason = "General Check-up";
        } else if (choice == 2) {
            reason = "Consultation";
        } else if (choice == 3) {
            reason = "Dental Check-up";
        } else if (choice == 4) {
            reason = "Laboratory Test";
        } else {
            reason = "Other";
        }

        System.out.println();
        System.out.println("====================================");
        System.out.println("       APPOINTMENT REQUESTED");
        System.out.println("====================================");

        System.out.println("Patient Name : " + name);
        System.out.println("Contact      : " + contact);
        System.out.println("Date         : " + date);
        System.out.println("Time         : " + time);
        System.out.println("Reason       : " + reason);

        System.out.println();
        System.out.println("Status: PENDING");
        System.out.println("Your appointment request has");
        System.out.println("been sent to Queueless Health Clinic.");
        System.out.println("Please wait for confirmation.");

        System.out.println("====================================");

        input.close();
    }
}
