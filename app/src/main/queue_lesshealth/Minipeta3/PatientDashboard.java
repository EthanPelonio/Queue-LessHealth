import java.util.ArrayList;
import java.util.Scanner;

public class PatientDashboard {

    public static void showDashboard(
            User patient,
            ArrayList<Doctor> doctors,
            ArrayList<Appointment> appointments) {

        if (patient == null) {

            System.out.println(
                    "\nPlease login first."
            );

            return;
        }

        Scanner sc = new Scanner(System.in);

        int choice;

        do {

            System.out.println("\n=================================");
            System.out.println("        PATIENT DASHBOARD");
            System.out.println("=================================");

            System.out.println(
                    "Welcome, " + patient.name + "!"
            );

            System.out.println("---------------------------------");
            System.out.println("[1] View Profile");
            System.out.println("[2] Doctor Search");
            System.out.println("[3] Book Appointment");
            System.out.println("[4] My Appointments");
            System.out.println("[5] Queue Status");
            System.out.println("[0] Back");
            System.out.println("---------------------------------");

            System.out.print("Choose: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1:

                    System.out.println(
                            "\n--- PATIENT PROFILE ---"
                    );

                    System.out.println(
                            "Name: " + patient.name
                    );

                    System.out.println(
                            "Username: " + patient.username
                    );

                    System.out.println(
                            "Age: " + patient.age
                    );

                    System.out.println(
                            "Contact: " + patient.contact
                    );

                    break;

                case 2:

                    DoctorSearch.searchDoctor(
                            doctors
                    );

                    break;

                case 3:

                    AppointmentBookingForm.showBookingForm(
                            patient,
                            doctors,
                            appointments
                    );

                    break;

                case 4:

                    System.out.println(
                            "\n--- MY APPOINTMENTS ---"
                    );

                    boolean found = false;

                    for (Appointment appointment :
                            appointments) {

                        if (appointment.patient == patient) {

                            found = true;

                            AppointmentConfirmationScreen
                                    .display(appointment);
                        }
                    }

                    if (!found) {
                        System.out.println(
                                "No appointments found."
                        );
                    }

                    break;

                case 5:

                    QueueandAppointmentDisplay.showQueue(
                            patient,
                            appointments
                    );

                    break;

                case 0:
                    break;

                default:
                    System.out.println(
                            "Invalid option."
                    );
            }

        } while (choice != 0);
    }
}