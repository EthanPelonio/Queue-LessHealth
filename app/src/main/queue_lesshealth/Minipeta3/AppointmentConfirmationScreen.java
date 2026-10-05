public class AppointmentConfirmationScreen {

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
}