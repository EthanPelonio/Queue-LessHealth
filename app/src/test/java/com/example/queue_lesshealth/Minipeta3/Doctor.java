package com.example.queue_lesshealth.Minipeta3;

import java.util.Scanner;

class Doctor {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println("        QUEUE-LESS HEALTH");
        System.out.println("=================================");
        System.out.println("        DOCTOR INFORMATION");
        System.out.println();

        System.out.print("Enter Doctor's Name: ");
        String doctorName = scanner.nextLine();

        System.out.print("Enter Specialization: ");
        String specialization = scanner.nextLine();

        System.out.print("Enter Doctor's Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter License Number: ");
        String licenseNumber = scanner.nextLine();

        System.out.print("Enter Contact Number: ");
        String contactNumber = scanner.nextLine();

        System.out.print("Enter Hospital/Clinic: ");
        String hospital = scanner.nextLine();

        System.out.print("Enter Consultation Schedule: ");
        String schedule = scanner.nextLine();

        System.out.println();
        System.out.println("=================================");
        System.out.println("        DOCTOR INFORMATION");
        System.out.println("=================================");
        System.out.println("Doctor's Name      : " + doctorName);
        System.out.println("Specialization     : " + specialization);
        System.out.println("Age                : " + age);
        System.out.println("License Number     : " + licenseNumber);
        System.out.println("Contact Number     : " + contactNumber);
        System.out.println("Hospital/Clinic    : " + hospital);
        System.out.println("Schedule           : " + schedule);
        System.out.println("=================================");
        System.out.println("Doctor information saved!");
        System.out.println("=================================");

        scanner.close();
    }
}