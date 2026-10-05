package com.example.queue_lesshealth.Minipeta3;

import java.util.*;

public class DoctorSearch {//dwa

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] doctors = {
                "Dr. Maria Santos - Cardiologist",
                "Dr. Juan Cruz - Dermatologist",
                "Dr. Anna Reyes - Pediatrician",
                "Dr. Carlos Garcia - Neurologist",
                "Dr. Sofia Lim - Dentist"
        };

        System.out.print("Search doctor: ");
        String search = sc.nextLine().toLowerCase();

        for (String doctor : doctors) {
            if (doctor.toLowerCase().contains(search)) {
                System.out.println(doctor);
            }
        }

        sc.close();
    }
}
