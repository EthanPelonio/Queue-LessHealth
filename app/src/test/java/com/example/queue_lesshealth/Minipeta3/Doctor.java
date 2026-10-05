import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println("        QUEUE-LESS HEALTH");
        System.out.println("=================================");
        System.out.println("        DOCTOR INFORMATION");
        System.out.println();

        System.out.print("Enter Doctor's Name: ");
        String doctorName = scanner.nextLine();

        System.out.print("Enter Specialization: ");
        String specialization = scanner.nextLine();

        System.out.print("Enter Doctor's Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter License Number: ");
        String licenseNumber = scanner.nextLine();

        System.out.print("Enter Contact Number: ");
        String contactNumber = scanner.nextLine();