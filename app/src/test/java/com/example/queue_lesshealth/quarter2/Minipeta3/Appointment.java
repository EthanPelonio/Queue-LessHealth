package com.example.queue_lesshealth.Minipeta3;

import java.util.Scanner;

class Appointment {
    public boolean patient;

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("==============================");
        System.out.println("     QUEUELESS HEALTH CLINIC");
        System.out.println("       APPOINTMENT SYSTEM");
        System.out.println("==============================");

        System.out.print("Patient Name: ");
        String name = input.nextLine();

        System.out.print("Age: ");
        int age = input.nextInt();
        input.nextLine();

        System.out.println();
        System.out.println("Choose a Service:");
        System.out.println("1. General Check-up");
        System.out.println("2. Dental Check-up");
        System.out.println("3. Laboratory Test");
        System.out.println("4. Consultation");

        System.out.print("Enter your choice: ");
        int service = input.nextInt();
        input.nextLine();

        String serviceName;

        if (service == 1) {
            serviceName = "General Check-up";
        } else if (service == 2) {
            serviceName = "Dental Check-up";
        } else if (service == 3) {
            serviceName = "Laboratory Test";
        } else if (service == 4) {
            serviceName = "Consultation";
        } else {
            serviceName = "Other Service";
        }

        System.out.print("Appointment Date: ");
        String date = input.nextLine();

        System.out.print("Appointment Time: ");
        String time = input.nextLine();

        System.out.println();
        System.out.println("==============================");
        System.out.println("    APPOINTMENT CONFIRMED");
        System.out.println("==============================");

        System.out.println("Patient Name : " + name);
        System.out.println("Age          : " + age);
        System.out.println("Service      : " + serviceName);
        System.out.println("Date         : " + date);
        System.out.println("Time         : " + time);
        System.out.println("Appointment #: QHC-001");

        System.out.println("==============================");
        System.out.println("Thank you for choosing");
        System.out.println("Queueless HEALTH CLINIC!");
        System.out.println("==============================");

        input.close();
    }
}

