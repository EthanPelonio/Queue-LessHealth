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
        class DoctorSearch {//UIYGUYGULIYGUKYGKUYHBK

            public void main(String[] args) {

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













    }









}





