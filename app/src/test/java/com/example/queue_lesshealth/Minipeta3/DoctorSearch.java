package com.example.queue_lesshealth.Minipeta3;

public class DoctorSearch {
}
aimport java.util.ArrayList;
import java.util.Scanner;

public class DoctorSearch {

    public static void displayAllDoctors(
            ArrayList<Doctor> doctors) {

        System.out.println("\n=================================");
        System.out.println("        AVAILABLE DOCTORS");
        System.out.println("=================================");

        for (Doctor doctor : doctors) {
            displayDoctor(doctor);
        }
    }

    public static void displayDoctor(Doctor doctor) {

        System.out.println(
                "ID: " + doctor.id +
                        " | Dr. " + doctor.name +
                        " | " + doctor.specialty +
                        " | " + doctor.schedule
        );
    }

    public static Doctor findDoctorById(
            ArrayList<Doctor> doctors,
            int id) {

        for (Doctor doctor : doctors) {

            if (doctor.id == id) {
                return doctor;
            }
        }

        return null;
    }

    public static void searchDoctor(
            ArrayList<Doctor> doctors) {

        Scanner sc = new Scanner(System.in);

        System.out.println("\n=================================");
        System.out.println("          DOCTOR SEARCH");
        System.out.println("=================================");

        System.out.println("[1] View All Doctors");
        System.out.println("[2] Search by Name");
        System.out.println("[3] Search by Specialty");
        System.out.println("[0] Back");

        System.out.print("Choose: ");
        int choice = Integer.parseInt(sc.nextLine());

        switch (choice) {

            case 1:

                displayAllDoctors(doctors);
                break;

            case 2:

                System.out.print("Enter doctor name: ");
                String name = sc.nextLine().toLowerCase();

                boolean nameFound = false;

                for (Doctor doctor : doctors) {

                    if (doctor.name.toLowerCase()
                            .contains(name)) {

                        displayDoctor(doctor);
                        nameFound = true;
                    }
                }

                if (!nameFound) {
                    System.out.println("No doctor found.");
                }

                break;

            case 3:

                System.out.print("Enter specialty: ");
                String specialty =
                        sc.nextLine().toLowerCase();

                boolean specialtyFound = false;

                for (Doctor doctor : doctors) {

                    if (doctor.specialty.toLowerCase()
                            .contains(specialty)) {

                        displayDoctor(doctor);
                        specialtyFound = true;
                    }
                }

                if (!specialtyFound) {
                    System.out.println("No doctor found.");
                }

                break;

            case 0:
                break;

            default:
                System.out.println("Invalid option.");
        }
    }
}