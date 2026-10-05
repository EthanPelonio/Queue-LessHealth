package com.example.queue_lesshealth.Minipeta3;

import java.util.Scanner;

public class AppointmentConfirmationScreen {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("======================================");
        System.out.println("       QUEUELESS HEALTH CLINIC");
        System.out.println("       APPOINTMENT CONFIRMATION");
        System.out.println("======================================");

        System.out.print("Patient Name: ");
        String name = input.nextLine();

        System.out.print("Appointment Date: ");
        String date = input.nextLine();

        System.out.print("Appointment Time: ");
        String time = input.nextLine();

        System.out.print("Reason: ");
        String reason = input.nextLine();

        System.out.println();
        System.out.println("======================================");
        System.out.println("       APPOINTMENT CONFIRMED!");
        System.out.println("======================================");

        System.out.println("Patient Name : " + name);
        System.out.println("Date         : " + date);
        System.out.println("Time         : " + time);
        System.out.println("Reason       : " + reason);
        System.out.println("Status       : CONFIRMED");

        System.out.println("--------------------------------------");
        System.out.println("Please arrive 10 minutes early.");
        System.out.println("Thank you for choosing");
        System.out.println("QUEUELESS HEALTH CLINIC!");
        System.out.println("======================================");

        input.close();
    }
}

