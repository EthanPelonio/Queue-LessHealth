package com.example.queue_lesshealth.Minipeta3;

import java.util.ArrayList;
import java.util.Scanner;

public class PatientDashboard {

    static class Patient {
        String id;
        String name;
        int age;
        String gender;
        String bloodType;
        String contact;

        Patient(String id, String name, int age, String gender,
                String bloodType, String contact) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.gender = gender;
            this.bloodType = bloodType;
            this.contact = contact;
        }
    }

    static class Appointment {
        String doctor;
        String date;
        String time;
        String status;

        Appointment(String doctor, String date, String time, String status) {
            this.doctor = doctor;
            this.date = date;
            this.time = time;
            this.status = status;
        }
    }

    static class MedicalRecord {
        String date;
        String diagnosis;
        String treatment;

        MedicalRecord(String date, String diagnosis, String treatment) {
            this.date = date;
            this.diagnosis = diagnosis;
            this.treatment = treatment;
        }
    }

    static Patient patient;

    static ArrayList<Appointment> appointments = new ArrayList<>();
    static ArrayList<MedicalRecord> medicalRecords = new ArrayList<>();

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        // Sample patient
        patient = new Patient(
                "P001",
                "Juan Dela Cruz",
                25,
                "Male",
                "O+",
                "09123456789"
        );

        // Sample appointments
        appointments.add(
                new Appointment(
                        "Dr. Maria Santos",
                        "October 10, 2026",
                        "10:00 AM",
                        "Confirmed"
                )
        );

        appointments.add(
                new Appointment(
                        "Dr. Pedro Reyes",
                        "October 20, 2026",
                        "2:00 PM",
                        "Pending"
                )
        );

        // Sample medical records
        medicalRecords.add(
                new MedicalRecord(
                        "September 15, 2026",
                        "Common Cold",
                        "Rest and prescribed medication"
                )
        );

        medicalRecords.add(
                new MedicalRecord(
                        "August 05, 2026",
                        "Fever",
                        "Paracetamol and hydration"
                )
        );

        showDashboard();
    }

    // Main dashboard
    static void showDashboard() {

        int choice;

        do {
            System.out.println("\n======================================");
            System.out.println("          PATIENT DASHBOARD");
            System.out.println("======================================");

            System.out.println("Welcome, " + patient.name + "!");
            System.out.println();

            System.out.println("1. View Patient Profile");
            System.out.println("2. View Appointments");
            System.out.println("3. View Medical Records");
            System.out.println("4. Book Appointment");
            System.out.println("5. Cancel Appointment");
            System.out.println("6. Exit");

            System.out.println("======================================");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    viewProfile();
                    break;

                case 2:
                    viewAppointments();
                    break;

                case 3:
                    viewMedicalRecords();
                    break;

                case 4:
                    bookAppointment();
                    break;

                case 5:
                    cancelAppointment();
                    break;

                case 6:
                    System.out.println("\nThank you for using the Patient Dashboard.");
                    break;

                default:
                    System.out.println("\nInvalid choice. Please try again.");
            }

        } while (choice != 6);
    }

    // Patient profile
    static void viewProfile() {

        System.out.println("\n======================================");
        System.out.println("          PATIENT PROFILE");
        System.out.println("======================================");

        System.out.println("Patient ID : " + patient.id);
        System.out.println("Name       : " + patient.name);
        System.out.println("Age        : " + patient.age);
        System.out.println("Gender     : " + patient.gender);
        System.out.println("Blood Type : " + patient.bloodType);
        System.out.println("Contact    : " + patient.contact);

        System.out.println("======================================");
    }

    // View appointments
    static void viewAppointments() {

        System.out.println("\n======================================");
        System.out.println("           APPOINTMENTS");
        System.out.println("======================================");

        if (appointments.isEmpty()) {
            System.out.println("No appointments found.");
            return;
        }

        for (int i = 0; i < appointments.size(); i++) {

            Appointment appointment = appointments.get(i);

            System.out.println("\nAppointment #" + (i + 1));
            System.out.println("Doctor : " + appointment.doctor);
            System.out.println("Date   : " + appointment.date);
            System.out.println("Time   : " + appointment.time);
            System.out.println("Status : " + appointment.status);
        }

        System.out.println("\n======================================");
    }

    // View medical records
    static void viewMedicalRecords() {

        System.out.println("\n======================================");
        System.out.println("          MEDICAL RECORDS");
        System.out.println("======================================");

        if (medicalRecords.isEmpty()) {
            System.out.println("No medical records found.");
            return;
        }

        for (MedicalRecord record : medicalRecords) {

            System.out.println("\nDate       : " + record.date);
            System.out.println("Diagnosis  : " + record.diagnosis);
            System.out.println("Treatment  : " + record.treatment);
        }

        System.out.println("\n======================================");
    }

    // Book appointment
    static void bookAppointment() {

        System.out.println("\n======================================");
        System.out.println("          BOOK APPOINTMENT");
        System.out.println("======================================");

        System.out.print("Doctor name: ");
        String doctor = scanner.nextLine();

        System.out.print("Date: ");
        String date = scanner.nextLine();

        System.out.print("Time: ");
        String time = scanner.nextLine();

        Appointment newAppointment =
                new Appointment(
                        doctor,
                        date,
                        time,
                        "Pending"
                );

        appointments.add(newAppointment);

        System.out.println("\nAppointment successfully booked!");
    }

    // Cancel appointment
    static void cancelAppointment() {

        System.out.println("\n======================================");
        System.out.println("          CANCEL APPOINTMENT");
        System.out.println("======================================");

        if (appointments.isEmpty()) {
            System.out.println("No appointments available.");
            return;
        }

        viewAppointments();

        System.out.print("\nEnter appointment number to cancel: ");
        int number = scanner.nextInt();
        scanner.nextLine();

        if (number >= 1 && number <= appointments.size()) {

            Appointment appointment =
                    appointments.get(number - 1);

            appointment.status = "Cancelled";

            System.out.println("Appointment cancelled successfully.");

        } else {
            System.out.println("Invalid appointment number.");
        }
    }
}