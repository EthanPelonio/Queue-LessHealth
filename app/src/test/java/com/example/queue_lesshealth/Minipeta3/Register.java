import java.util.ArrayList;
import java.util.Scanner;

public class Register {

    public static User registerUser(
            ArrayList<User> users) {

        Scanner sc = new Scanner(System.in);

        System.out.println("\n=================================");
        System.out.println("             REGISTER");
        System.out.println("=================================");

        System.out.print("Full Name: ");
        String name = sc.nextLine();

        System.out.print("Username: ");
        String username = sc.nextLine();

        for (User user : users) {

            if (user.username.equalsIgnoreCase(username)) {

                System.out.println(
                        "\nUsername already exists."
                );

                return null;
            }
        }

        System.out.print("Password: ");
        String password = sc.nextLine();

        System.out.print("Age: ");
        int age = Integer.parseInt(sc.nextLine());

        System.out.print("Contact Number: ");
        String contact = sc.nextLine();

        User newUser = new User(
                name,
                username,
                password,
                age,
                contact
        );

        users.add(newUser);

        System.out.println("\n=================================");
        System.out.println("      REGISTRATION SUCCESSFUL");
        System.out.println("=================================");
        System.out.println(
                "Welcome, " + name + "!"
        );

        return newUser;
    }
}