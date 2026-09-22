package com.example.queue_lesshealth.Minipeta3;


import java.util.Scanner;

public class DoctorSearch {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] doctors = {
                "Dr. Santos - General Medicine",
                "Dr. Cruz - Pediatrics",
                "Dr. Reyes - Cardiology",
                "Dr. Garcia - Dermatology"
        };

        System.out.println("================================");
        System.out.println("       DOCTOR SEARCH SYSTEM");
        System.out.println("================================");

        System.out.print("Enter doctor's name or specialty: ");
        String search = scanner.nextLine().toLowerCase();

        System.out.println("\nSearch Results:");

        boolean found = false;

        for (String doctor : doctors) {
            if (doctor.toLowerCase().contains(search)) {
                System.out.println("- " + doctor);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No doctor found.");
        }

        scanner.close();
    }
}
