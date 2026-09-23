import java.util.ArrayList;
import java.util.Scanner;

public class QueueandAppointmentDisplay {

    public static void showQueue(
            User patient,
            ArrayList<Appointment> appointments) {

        if (patient == null) {

            System.out.println(
                    "\nPlease login first."
            );

            return;
        }

        System.out.println("\n=================================");
        System.out.println("      QUEUE & APPOINTMENTS");
        System.out.println("=================================");

        boolean found = false;

        for (Appointment appointment :
                appointments) {

            if (appointment.patient == patient) {

                found = true;

                System.out.println(
                        "\nAppointment ID: "
                                + appointment.id
                );

                System.out.println(
                        "Doctor: "
                                + appointment.doctor.name
                );

                System.out.println(
                        "Date: "
                                + appointment.date
                );

                System.out.println(
                        "Time: "
                                + appointment.time
                );

                System.out.println(
                        "Queue Number: "
                                + appointment.queueNumber
                );

                System.out.println(
                        "Status: "
                                + appointment.status
                );

                int currentlyServing = 1;

                int patientsAhead =
                        appointment.queueNumber
                                - currentlyServing;

                if (patientsAhead < 0) {
                    patientsAhead = 0;
                }

                System.out.println(
                        "Currently Serving: #"
                                + currentlyServing
                );

                System.out.println(
                        "Patients Ahead: "
                                + patientsAhead
                );

                if (appointment.queueNumber
                        == currentlyServing) {

                    System.out.println(
                            "Queue Status: YOUR TURN"
                    );

                } else {

                    System.out.println(
                            "Queue Status: WAITING"
                    );
                }

                System.out.println(
                        "---------------------------------"
                );
            }
        }

        if (!found) {

            System.out.println(
                    "No appointments found."
            );
        }
    }

    public static Appointment selectAppointment(
            User patient,
            ArrayList<Appointment> appointments) {

        if (patient == null) {
            return null;
        }

        Scanner sc = new Scanner(System.in);

        System.out.println(
                "\n--- YOUR APPOINTMENTS ---"
        );

        for (Appointment appointment :
                appointments) {

            if (appointment.patient == patient) {

                System.out.println(
                        "ID #" + appointment.id +
                                " | Dr. " +
                                appointment.doctor.name +
                                " | " +
                                appointment.date +
                                " | " +
                                appointment.status
                );
            }
        }

        System.out.print(
                "Enter Appointment ID: "
        );

        int id = Integer.parseInt(sc.nextLine());

        for (Appointment appointment :
                appointments) {

            if (appointment.id == id &&
                    appointment.patient == patient) {

                return appointment;
            }
        }

        System.out.println(
                "Appointment not found."
        );

        return null;
    }
}