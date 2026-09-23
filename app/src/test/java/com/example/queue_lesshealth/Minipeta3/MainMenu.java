import java.util.ArrayList;
import java.util.Scanner;
import org.junit.Test;


public class Main {
@Test
    static Scanner sc = new Scanner(System.in);

    // =========================================================
    // DATA STORAGE
    // =========================================================

    static ArrayList<User> users = new ArrayList<>();
    static ArrayList<Doctor> doctors = new ArrayList<>();
    static ArrayList<Appointment> appointments = new ArrayList<>();

    static User currentUser = null;

    // =========================================================
    // MAIN PROGRAM
    // =========================================================

    public static void main(String[] args) {

        initializeDoctors();
        initializeDemoUser();

        System.out.println("==============================================");
        System.out.println("       HEALTHCARE APPOINTMENT SYSTEM");
        System.out.println("==============================================");
        System.out.println("Welcome to the Healthcare Appointment System!");

        mainMenu();

        System.out.println("\nThank you for using the system!");
        sc.close();
    }

    // =========================================================
    // MAIN MENU
    // =========================================================

    static void mainMenu() {

        int choice;

        do {

            System.out.println("\n==============================================");
            System.out.println("                  MAIN MENU");
            System.out.println("==============================================");

            if (currentUser != null) {
                System.out.println("Logged in as: " + currentUser.name);
            } else {
                System.out.println("Status: Not logged in");
            }

            System.out.println("----------------------------------------------");
            System.out.println("[1] Register");
            System.out.println("[2] Login");
            System.out.println("[3] Doctor Search");
            System.out.println("[4] Patient Dashboard");
            System.out.println("[5] Book Appointment");
            System.out.println("[6] Appointment Request");
            System.out.println("[7] Appointment Confirmation");
            System.out.println("[8] Queue & Appointment Display");
            System.out.println("[9] Logout");
            System.out.println("[0] Exit");
            System.out.println("----------------------------------------------");

            choice = getInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    register();
                    break;

                case 2:
                    login();
                    break;

                case 3:
                    doctorSearch();
                    break;

                case 4:
                    patientDashboard();
                    break;

                case 5:
                    bookAppointment();
                    break;

                case 6:
                    appointmentRequest();
                    break;

                case 7:
                    appointmentConfirmation();
                    break;

                case 8:
                    queueAndAppointmentDisplay();
                    break;

                case 9:
                    logout();
                    break;

                case 0:
                    System.out.println("\nExiting system...");
                    break;

                default:
                    System.out.println("\nInvalid choice.");
                    System.out.println("Please select a valid menu option.");
            }

        } while (choice != 0);
    }

    // =========================================================
    // REGISTER
    // =========================================================

    static void register() {

        System.out.println("\n==============================================");
        System.out.println("                 REGISTER");
        System.out.println("==============================================");

        System.out.print("Enter full name: ");
        String name = sc.nextLine();

        System.out.print("Enter username: ");
        String username = sc.nextLine();

        if (findUser(username) != null) {
            System.out.println("\nUsername already exists.");
            return;
        }

        System.out.print("Enter password: ");
        String password = sc.nextLine();

        System.out.print("Enter age: ");
        int age = getInt("");

        System.out.print("Enter contact number: ");
        String contact = sc.nextLine();

        User newUser = new User(
                name,
                username,
                password,
                age,
                contact
        );

        users.add(newUser);

        System.out.println("\n==============================================");
        System.out.println("       REGISTRATION SUCCESSFUL");
        System.out.println("==============================================");
        System.out.println("Name     : " + name);
        System.out.println("Username : " + username);
        System.out.println("Age      : " + age);
        System.out.println("Contact  : " + contact);
        System.out.println("----------------------------------------------");
        System.out.println("You may now log in.");
    }

    // =========================================================
    // LOGIN
    // =========================================================

    static void login() {

        System.out.println("\n==============================================");
        System.out.println("                    LOGIN");
        System.out.println("==============================================");

        if (currentUser != null) {
            System.out.println("You are already logged in as "
                    + currentUser.name + ".");
            return;
        }

        System.out.print("Username: ");
        String username = sc.nextLine();

        System.out.print("Password: ");
        String password = sc.nextLine();

        User user = findUser(username);

        if (user != null && user.password.equals(password)) {

            currentUser = user;

            System.out.println("\n==============================================");
            System.out.println("              LOGIN SUCCESSFUL");
            System.out.println("==============================================");
            System.out.println("Welcome, " + currentUser.name + "!");

        } else {

            System.out.println("\nInvalid username or password.");
        }
    }

    // =========================================================
    // LOGOUT
    // =========================================================

    static void logout() {

        if (currentUser == null) {
            System.out.println("\nNo user is currently logged in.");
            return;
        }

        System.out.println("\nGoodbye, " + currentUser.name + "!");
        currentUser = null;

        System.out.println("You have been logged out.");
    }

    // =========================================================
    // DOCTOR SEARCH
    // =========================================================

    static void doctorSearch() {

        System.out.println("\n==============================================");
        System.out.println("                DOCTOR SEARCH");
        System.out.println("==============================================");

        System.out.println("[1] View All Doctors");
        System.out.println("[2] Search by Specialty");
        System.out.println("[3] Search by Doctor Name");
        System.out.println("[0] Back");

        int choice = getInt("Choose an option: ");

        if (choice == 1) {

            displayAllDoctors();

        } else if (choice == 2) {

            System.out.print("\nEnter specialty: ");
            String specialty = sc.nextLine();

            boolean found = false;

            System.out.println("\n--- SEARCH RESULTS ---");

            for (Doctor doctor : doctors) {

                if (doctor.specialty.toLowerCase()
                        .contains(specialty.toLowerCase())) {

                    displayDoctor(doctor);
                    found = true;
                }
            }

            if (!found) {
                System.out.println("No doctors found for that specialty.");
            }

        } else if (choice == 3) {

            System.out.print("\nEnter doctor name: ");
            String name = sc.nextLine();

            boolean found = false;

            System.out.println("\n--- SEARCH RESULTS ---");

            for (Doctor doctor : doctors) {

                if (doctor.name.toLowerCase()
                        .contains(name.toLowerCase())) {

                    displayDoctor(doctor);
                    found = true;
                }
            }

            if (!found) {
                System.out.println("No doctor found.");
            }

        } else if (choice == 0) {

            return;

        } else {

            System.out.println("Invalid choice.");
        }
    }

    // =========================================================
    // PATIENT DASHBOARD
    // =========================================================

    static void patientDashboard() {

        if (!requireLogin()) {
            return;
        }

        int choice;

        do {

            System.out.println("\n==============================================");
            System.out.println("             PATIENT DASHBOARD");
            System.out.println("==============================================");
            System.out.println("Welcome, " + currentUser.name + "!");
            System.out.println("----------------------------------------------");

            System.out.println("[1] View Profile");
            System.out.println("[2] Doctor Search");
            System.out.println("[3] Book Appointment");
            System.out.println("[4] My Appointments");
            System.out.println("[5] Appointment Request");
            System.out.println("[6] Queue Status");
            System.out.println("[0] Back to Main Menu");

            choice = getInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    viewProfile();
                    break;

                case 2:
                    doctorSearch();
                    break;

                case 3:
                    bookAppointment();
                    break;

                case 4:
                    viewMyAppointments();
                    break;

                case 5:
                    appointmentRequest();
                    break;

                case 6:
                    queueAndAppointmentDisplay();
                    break;

                case 0:
                    System.out.println("Returning to Main Menu...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);
    }

    // =========================================================
    // VIEW PROFILE
    // =========================================================

    static void viewProfile() {

        if (!requireLogin()) {
            return;
        }

        System.out.println("\n==============================================");
        System.out.println("                MY PROFILE");
        System.out.println("==============================================");

        System.out.println("Full Name : " + currentUser.name);
        System.out.println("Username  : " + currentUser.username);
        System.out.println("Age       : " + currentUser.age);
        System.out.println("Contact   : " + currentUser.contact);

        System.out.println("==============================================");
    }

    // =========================================================
    // BOOK APPOINTMENT
    // =========================================================

    static void bookAppointment() {

        if (!requireLogin()) {
            return;
        }

        System.out.println("\n==============================================");
        System.out.println("             BOOK APPOINTMENT");
        System.out.println("==============================================");

        displayAllDoctors();

        int doctorNumber = getInt("\nEnter Doctor ID: ");

        Doctor selectedDoctor = findDoctorById(doctorNumber);

        if (selectedDoctor == null) {

            System.out.println("\nDoctor not found.");
            return;
        }

        System.out.println("\nSelected Doctor:");
        displayDoctor(selectedDoctor);

        System.out.print("\nEnter appointment date: ");
        String date = sc.nextLine();

        System.out.print("Enter appointment time: ");
        String time = sc.nextLine();

        System.out.print("Enter reason for appointment: ");
        String reason = sc.nextLine();

        int queueNumber = calculateQueueNumber();

        Appointment appointment = new Appointment(
                currentUser,
                selectedDoctor,
                date,
                time,
                reason,
                queueNumber,
                "PENDING"
        );

        appointments.add(appointment);

        System.out.println("\n==============================================");
        System.out.println("       APPOINTMENT BOOKING SUCCESSFUL");
        System.out.println("==============================================");

        System.out.println("Appointment ID : " + appointment.id);
        System.out.println("Patient        : " + currentUser.name);
        System.out.println("Doctor         : " + selectedDoctor.name);
        System.out.println("Specialty      : " + selectedDoctor.specialty);
        System.out.println("Date           : " + date);
        System.out.println("Time           : " + time);
        System.out.println("Reason         : " + reason);
        System.out.println("Queue Number   : " + queueNumber);
        System.out.println("Status         : PENDING");

        System.out.println("==============================================");
    }

    // =========================================================
    // APPOINTMENT REQUEST
    // =========================================================

    static void appointmentRequest() {

        if (!requireLogin()) {
            return;
        }

        System.out.println("\n==============================================");
        System.out.println("            APPOINTMENT REQUEST");
        System.out.println("==============================================");

        ArrayList<Appointment> myAppointments =
                getUserAppointments();

        if (myAppointments.isEmpty()) {

            System.out.println("You do not have any appointments.");
            return;
        }

        displayUserAppointments();

        int appointmentId =
                getInt("\nEnter Appointment ID: ");

        Appointment appointment =
                findAppointmentById(appointmentId);

        if (appointment == null ||
                appointment.patient != currentUser) {

            System.out.println("\nAppointment not found.");
            return;
        }

        System.out.println("\nSelected Appointment:");
        displayAppointment(appointment);

        System.out.println("\nRequest Options:");
        System.out.println("[1] Confirm Appointment");
        System.out.println("[2] Cancel Appointment");
        System.out.println("[3] Reschedule Request");
        System.out.println("[0] Back");

        int choice = getInt("Choose an option: ");

        switch (choice) {

            case 1:

                appointment.status = "CONFIRMED";

                System.out.println("\nAppointment request approved.");
                System.out.println("Status: CONFIRMED");

                break;

            case 2:

                appointment.status = "CANCELLED";

                System.out.println("\nAppointment cancelled.");
                System.out.println("Status: CANCELLED");

                break;

            case 3:

                System.out.print("\nEnter new date: ");
                String newDate = sc.nextLine();

                System.out.print("Enter new time: ");
                String newTime = sc.nextLine();

                appointment.date = newDate;
                appointment.time = newTime;
                appointment.status = "RESCHEDULED";

                System.out.println("\nReschedule request submitted.");
                System.out.println("New Date: " + newDate);
                System.out.println("New Time: " + newTime);

                break;

            case 0:
                break;

            default:
                System.out.println("Invalid option.");
        }
    }

    // =========================================================
    // APPOINTMENT CONFIRMATION
    // =========================================================

    static void appointmentConfirmation() {

        if (!requireLogin()) {
            return;
        }

        System.out.println("\n==============================================");
        System.out.println("         APPOINTMENT CONFIRMATION");
        System.out.println("==============================================");

        ArrayList<Appointment> myAppointments =
                getUserAppointments();

        if (myAppointments.isEmpty()) {

            System.out.println("You have no appointments.");
            return;
        }

        displayUserAppointments();

        int id = getInt("\nEnter Appointment ID: ");

        Appointment appointment = findAppointmentById(id);

        if (appointment == null ||
                appointment.patient != currentUser) {

            System.out.println("Appointment not found.");
            return;
        }

        System.out.println("\n==============================================");
        System.out.println("          APPOINTMENT INFORMATION");
        System.out.println("==============================================");

        displayAppointment(appointment);

        System.out.println("----------------------------------------------");

        if (appointment.status.equals("CANCELLED")) {

            System.out.println("This appointment has been cancelled.");

        } else {

            appointment.status = "CONFIRMED";

            System.out.println("Appointment confirmed successfully.");
            System.out.println("Please arrive on time.");

        }

        System.out.println("==============================================");
    }

    // =========================================================
    // QUEUE & APPOINTMENT DISPLAY
    // =========================================================

    static void queueAndAppointmentDisplay() {

        if (!requireLogin()) {
            return;
        }

        System.out.println("\n==============================================");
        System.out.println("        QUEUE & APPOINTMENT DISPLAY");
        System.out.println("==============================================");

        ArrayList<Appointment> myAppointments =
                getUserAppointments();

        if (myAppointments.isEmpty()) {

            System.out.println("You have no appointments.");
            return;
        }

        for (Appointment appointment : myAppointments) {

            displayAppointment(appointment);

            int currentlyServing = 1;

            int patientsAhead =
                    appointment.queueNumber - currentlyServing;

            if (patientsAhead < 0) {
                patientsAhead = 0;
            }

            System.out.println("Currently Serving : Queue #"
                    + currentlyServing);

            System.out.println("Patients Ahead    : "
                    + patientsAhead);

            if (appointment.queueNumber == currentlyServing) {

                System.out.println("Queue Status      : YOUR TURN");

            } else {

                System.out.println("Queue Status      : WAITING");
            }

            System.out.println("----------------------------------------------");
        }
    }

    // =========================================================
    // MY APPOINTMENTS
    // =========================================================

    static void viewMyAppointments() {

        if (!requireLogin()) {
            return;
        }

        System.out.println("\n==============================================");
        System.out.println("             MY APPOINTMENTS");
        System.out.println("==============================================");

        ArrayList<Appointment> myAppointments =
                getUserAppointments();

        if (myAppointments.isEmpty()) {

            System.out.println("You currently have no appointments.");
            return;
        }

        for (Appointment appointment : myAppointments) {
            displayAppointment(appointment);
            System.out.println("----------------------------------------------");
        }
    }

    // =========================================================
    // DISPLAY FUNCTIONS
    // =========================================================

    static void displayAllDoctors() {

        System.out.println("\n----------------------------------------------");
        System.out.println("              AVAILABLE DOCTORS");
        System.out.println("----------------------------------------------");

        for (Doctor doctor : doctors) {
            displayDoctor(doctor);
        }

        System.out.println("----------------------------------------------");
    }

    static void displayDoctor(Doctor doctor) {

        System.out.println(
                "ID: " + doctor.id +
                        " | " + doctor.name +
                        " | " + doctor.specialty +
                        " | " + doctor.schedule
        );
    }

    static void displayAppointment(Appointment appointment) {

        System.out.println("Appointment ID : " + appointment.id);
        System.out.println("Doctor        : " + appointment.doctor.name);
        System.out.println("Specialty     : " + appointment.doctor.specialty);
        System.out.println("Date          : " + appointment.date);
        System.out.println("Time          : " + appointment.time);
        System.out.println("Reason        : " + appointment.reason);
        System.out.println("Queue Number  : " + appointment.queueNumber);
        System.out.println("Status        : " + appointment.status);
    }

    static void displayUserAppointments() {

        for (Appointment appointment : appointments) {

            if (appointment.patient == currentUser) {

                System.out.println("----------------------------------------------");
                System.out.println(
                        "ID #" + appointment.id +
                                " | Dr. " + appointment.doctor.name +
                                " | " + appointment.date +
                                " | " + appointment.time +
                                " | " + appointment.status
                );
            }
        }
    }

    // =========================================================
    // SEARCH / FIND FUNCTIONS
    // =========================================================

    static User findUser(String username) {

        for (User user : users) {

            if (user.username.equalsIgnoreCase(username)) {
                return user;
            }
        }

        return null;
    }

    static Doctor findDoctorById(int id) {

        for (Doctor doctor : doctors) {

            if (doctor.id == id) {
                return doctor;
            }
        }

        return null;
    }

    static Appointment findAppointmentById(int id) {

        for (Appointment appointment : appointments) {

            if (appointment.id == id) {
                return appointment;
            }
        }

        return null;
    }

    static ArrayList<Appointment> getUserAppointments() {

        ArrayList<Appointment> result =
                new ArrayList<>();

        if (currentUser == null) {
            return result;
        }

        for (Appointment appointment : appointments) {

            if (appointment.patient == currentUser) {
                result.add(appointment);
            }
        }

        return result;
    }

    // =========================================================
    // QUEUE NUMBER
    // =========================================================

    static int calculateQueueNumber() {

        return appointments.size() + 1;
    }

    // =========================================================
    // LOGIN REQUIREMENT
    // =========================================================

    static boolean requireLogin() {

        if (currentUser == null) {

            System.out.println("\nYou must log in first.");
            System.out.println("Please select Login from the Main Menu.");

            return false;
        }

        return true;
    }

    // =========================================================
    // INPUT HANDLING
    // =========================================================

    static int getInt(String message) {

        while (true) {

            System.out.print(message);

            try {

                int number = Integer.parseInt(sc.nextLine());

                return number;

            } catch (NumberFormatException e) {

                System.out.println("Please enter a valid number.");
            }
        }
    }

    // =========================================================
    // INITIAL DATA
    // =========================================================

    static void initializeDoctors() {

        doctors.add(
                new Doctor(
                        1,
                        "Dr. Maria Santos",
                        "Cardiologist",
                        "Monday - Friday, 9:00 AM - 3:00 PM"
                )
        );

        doctors.add(
                new Doctor(
                        2,
                        "Dr. John Reyes",
                        "Pediatrician",
                        "Monday - Friday, 10:00 AM - 4:00 PM"
                )
        );

        doctors.add(
                new Doctor(
                        3,
                        "Dr. Angela Cruz",
                        "Dermatologist",
                        "Tuesday - Saturday, 9:00 AM - 2:00 PM"
                )
        );

        doctors.add(
                new Doctor(
                        4,
                        "Dr. Daniel Garcia",
                        "General Physician",
                        "Monday - Saturday, 8:00 AM - 5:00 PM"
                )
        );

        doctors.add(
                new Doctor(
                        5,
                        "Dr. Sophia Mendoza",
                        "Neurologist",
                        "Monday - Friday, 1:00 PM - 5:00 PM"
                )
        );
    }

    // =========================================================
    // DEMO ACCOUNT
    // =========================================================

    static void initializeDemoUser() {

        users.add(
                new User(
                        "Juan Dela Cruz",
                        "juan",
                        "12345",
                        17,
                        "09123456789"
                )
        );
    }

    // =========================================================
    // USER CLASS
    // =========================================================

    static class User {

        String name;
        String username;
        String password;
        int age;
        String contact;

        User(
                String name,
                String username,
                String password,
                int age,
                String contact
        ) {

            this.name = name;
            this.username = username;
            this.password = password;
            this.age = age;
            this.contact = contact;
        }
    }

    // =========================================================
    // DOCTOR CLASS
    // =========================================================

    static class Doctor {

        int id;
        String name;
        String specialty;
        String schedule;

        Doctor(
                int id,
                String name,
                String specialty,
                String schedule
        ) {

            this.id = id;
            this.name = name;
            this.specialty = specialty;
            this.schedule = schedule;
        }
    }

    // =========================================================
    // APPOINTMENT CLASS
    // =========================================================

    static class Appointment {

        static int nextId = 1001;

        int id;
        User patient;
        Doctor doctor;
        String date;
        String time;
        String reason;
        int queueNumber;
        String status;

        Appointment(
                User patient,
                Doctor doctor,
                String date,
                String time,
                String reason,
                int queueNumber,
                String status
        ) {

            this.id = nextId++;
            this.patient = patient;
            this.doctor = doctor;
            this.date = date;
            this.time = time;
            this.reason = reason;
            this.queueNumber = queueNumber;
            this.status = status;
        }
    }
}