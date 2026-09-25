import java.util.Scanner;
import org.junit.Test;

public class Login {
    @Test
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Sample registered account
        String registeredEmail = "patient@gmail.com";
        String registeredPassword = "12345";

        System.out.println("=================================");
        System.out.println("        QUEUE-LESS HEALTH");
        System.out.println("=================================");
        System.out.println("              LOGIN");
        System.out.println();

        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        System.out.print("Enter Password: ");
        String password = scanner.nextLine();

        // Check login information
        if (email.equals(registeredEmail) &&
                password.equals(registeredPassword)) {

            System.out.println();
            System.out.println("Login Successful!");
            System.out.println("Welcome to Queue-Less Health.");

        } else {

            System.out.println();
            System.out.println("Invalid email or password.");
            System.out.println("Please try again.");
        }

        scanner.close();
    }
}