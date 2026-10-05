public class Appointment {

    static int nextId = 1001;

    int id;
    User patient;
    Doctor doctor;
    String date;
    String time;
    String reason;
    int queueNumber;
    String status;

    public Appointment(
            User patient,
            Doctor doctor,
            String date,
            String time,
            String reason,
            int queueNumber,
            String status) {

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