package com.example.queue_lesshealth.Minipeta3;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.Scanner;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class DoctorSearchTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
        class DoctorSearch {

            public void main(String[] args) {

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














    }









}





