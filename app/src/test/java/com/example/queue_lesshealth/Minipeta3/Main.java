package com.example.queue_lesshealth.Minipeta3;

import java.util.Scanner;

class BookingForm {

    // =========================
    // PATIENT CLASS
    // =========================
    static class Patient {
        String name;

        Patient(String name) {
            this.name = name;
        }
    }

    // =========================
    // DOCTOR CLASS
    // =========================
    static class Doctor {
        String name;
        String specialty;

        Doctor(String name, String specialty) {
            this.name = name;
            this.specialty = specialty;
        }
    }

    // =========================
    // APPOINTMENT CLASS
    // =========================
    static class Appointment {
        String id;
        Patient patient;
        Doctor doctor;
        String date;
        String time;
        String reason;
        int queueNumber;
        String status;
    }

    // =========================
    // APPOINTMENT BOOKING FORM
    // =========================
    public static Appointment bookAppointment(Scanner scanner) {

        Appointment appointment = new Appointment();

        System.out.println("\n=================================");
        System.out.println("       APPOINTMENT BOOKING");
        System.out.println("=================================");

        System.out.print("Patient Name   : ");
        String patientName = scanner.nextLine();

        System.out.print("Doctor Name    : ");
        String doctorName = scanner.nextLine();

        System.out.print("Specialty      : ");
        String specialty = scanner.nextLine();

        System.out.print("Date           : ");
        String date = scanner.nextLine();

        System.out.print("Time           : ");
        String time = scanner.nextLine();

        System.out.print("Reason         : ");
        String reason = scanner.nextLine();

        // Create patient
        appointment.patient = new Patient(patientName);

        // Create doctor
        appointment.doctor = new Doctor(doctorName, specialty);

        // Appointment details
        appointment.id = "APT-001";
        appointment.date = date;
        appointment.time = time;
        appointment.reason = reason;
        appointment.queueNumber = 1;
        appointment.status = "PENDING";

        System.out.println("\nAppointment successfully booked!");

        return appointment;
    }

    // =========================
    // APPOINTMENT CONFIRMATION
    // =========================
    public static void display(Appointment appointment) {

        if (appointment == null) {
            System.out.println("No appointment found.");
            return;
        }

        System.out.println("\n=================================");
        System.out.println("    APPOINTMENT CONFIRMATION");
        System.out.println("=================================");

        System.out.println("Appointment ID : " + appointment.id);
        System.out.println("Patient        : " + appointment.patient.name);
        System.out.println("Doctor         : " + appointment.doctor.name);
        System.out.println("Specialty      : " + appointment.doctor.specialty);
        System.out.println("Date           : " + appointment.date);
        System.out.println("Time           : " + appointment.time);
        System.out.println("Reason         : " + appointment.reason);
        System.out.println("Queue Number   : " + appointment.queueNumber);
        System.out.println("Status         : " + appointment.status);

        System.out.println("=================================");
    }

    public static void confirm(Appointment appointment) {

        if (appointment == null) {
            System.out.println("Appointment not found.");
            return;
        }

        appointment.status = "CONFIRMED";

        System.out.println("\nAppointment successfully confirmed!");

        display(appointment);
    }

    // =========================
    // MAIN PROGRAM
    // =========================
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println("     ONLINE APPOINTMENT SYSTEM");
        System.out.println("=================================");

        // Book appointment
        Appointment appointment = bookAppointment(scanner);

        // Ask user if they want to confirm
        System.out.print("\nConfirm appointment? (Y/N): ");
        String choice = scanner.nextLine();

        if (choice.equalsIgnoreCase("Y")) {
            confirm(appointment);
        } else {
            System.out.println("\nAppointment was not confirmed.");

            display(appointment);
        }

        scanner.close();
    }
}
