import java.util.ArrayList;
import java.util.Scanner;

public class AppointmentRequest {

    public static void showRequests(
            User patient,
            ArrayList<Appointment> appointments) {

        Scanner sc = new Scanner(System.in);

        System.out.println("\n=================================");
        System.out.println("      APPOINTMENT REQUEST");
        System.out.println("=================================");

        boolean found = false;

        for (Appointment appointment : appointments) {

            if (appointment.patient == patient) {

                found = true;

                System.out.println("---------------------------------");
                System.out.println("ID: " + appointment.id);
                System.out.println("Doctor: " + appointment.doctor.name);
                System.out.println("Date: " + appointment.date);
                System.out.println("Time: " + appointment.time);
                System.out.println("Status: " + appointment.status);
            }
        }

        if (!found) {
            System.out.println("You have no appointment requests.");
            return;
        }

        System.out.println("---------------------------------");
        System.out.print("Enter Appointment ID: ");

        int id = Integer.parseInt(sc.nextLine());

        Appointment selected = null;

        for (Appointment appointment : appointments) {

            if (appointment.id == id &&
                    appointment.patient == patient) {

                selected = appointment;
                break;
            }
        }

        if (selected == null) {
            System.out.println("Appointment not found.");
            return;
        }

        System.out.println("\n[1] Confirm");
        System.out.println("[2] Cancel");
        System.out.println("[3] Reschedule");
        System.out.println("[0] Back");

        System.out.print("Choose: ");
        int choice = Integer.parseInt(sc.nextLine());

        switch (choice) {

            case 1:
                selected.status = "CONFIRMED";
                System.out.println("Appointment confirmed.");
                break;

            case 2:
                selected.status = "CANCELLED";
                System.out.println("Appointment cancelled.");
                break;

            case 3:

                System.out.print("New Date: ");
                selected.date = sc.nextLine();

                System.out.print("New Time: ");
                selected.time = sc.nextLine();

                selected.status = "RESCHEDULED";

                System.out.println("Appointment rescheduled.");
                break;

            case 0:
                break;

            default:
                System.out.println("Invalid option.");
        }
    }
}