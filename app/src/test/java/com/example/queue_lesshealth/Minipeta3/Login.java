import java.util.ArrayList;
import java.util.Scanner;

public class Login {

    public static User loginUser(
            ArrayList<User> users) {

        Scanner sc = new Scanner(System.in);

        System.out.println("\n=================================");
        System.out.println("             LOGIN");
        System.out.println("=================================");

        System.out.print("Username: ");
        String username = sc.nextLine();

        System.out.print("Password: ");
        String password = sc.nextLine();

        for (User user : users) {

            if (user.username.equals(username)
                    && user.password.equals(password)) {

                System.out.println("\nLogin successful!");
                System.out.println("Welcome, " + user.name + "!");

                return user;
            }
        }

        System.out.println("\nInvalid username or password.");

        return null;
    }
}