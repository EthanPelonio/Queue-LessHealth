import java.util.ArrayList;
import java.util.Scanner;

public class AppointmentBookingForm {

    public static Appointment createAppointment(
            User patient,
            Doctor doctor,
            String date,
            String time,
            String reason,
            ArrayList<Appointment> appointments) {

        int queueNumber = appointments.size() + 1;

        Appointment appointment = new Appointment(
                patient,
                doctor,
                date,
                time,
                reason,
                queueNumber,
                "PENDING"
        );

        appointments.add(appointment);

        return appointment;
    }

    public static void showBookingForm(
            User patient,
            ArrayList<Doctor> doctors,
            ArrayList<Appointment> appointments) {

        Scanner sc = new Scanner(System.in);

        System.out.println("\n=================================");
        System.out.println("       APPOINTMENT BOOKING");
        System.out.println("=================================");

        DoctorSearch.displayAllDoctors(doctors);

        System.out.print("Enter Doctor ID: ");
        int doctorId = Integer.parseInt(sc.nextLine());

        Doctor doctor = DoctorSearch.findDoctorById(doctors, doctorId);

        if (doctor == null) {
            System.out.println("Doctor not found.");
            return;
        }

        System.out.println("\nSelected Doctor:");
        DoctorSearch.displayDoctor(doctor);

        System.out.print("Appointment Date: ");
        String date = sc.nextLine();

        System.out.print("Appointment Time: ");
        String time = sc.nextLine();

        System.out.print("Reason for Appointment: ");
        String reason = sc.nextLine();

        Appointment appointment = createAppointment(
                patient,
                doctor,
                date,
                time,
                reason,
                appointments
        );

        System.out.println("\n=================================");
        System.out.println("   APPOINTMENT CREATED");
        System.out.println("=================================");
        System.out.println("Appointment ID: " + appointment.id);
        System.out.println("Patient: " + patient.name);
        System.out.println("Doctor: " + doctor.name);
        System.out.println("Date: " + date);
        System.out.println("Time: " + time);
        System.out.println("Queue Number: " + appointment.queueNumber);
        System.out.println("Status: " + appointment.status);
    }
}