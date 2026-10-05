import java.util.Scanner;

public class Main {

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
