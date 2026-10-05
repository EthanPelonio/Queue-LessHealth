public class MenuTestingFile {

    public static boolean isValidChoice(int choice) {

        return choice >= 0 && choice <= 9;
    }

    public static String getMenuName(int choice) {

        switch (choice) {

            case 1:
                return "Register";

            case 2:
                return "Login";

            case 3:
                return "Doctor Search";

            case 4:
                return "Patient Dashboard";

            case 5:
                return "Book Appointment";

            case 6:
                return "Appointment Request";

            case 7:
                return "Appointment Confirmation";

            case 8:
                return "Queue Display";

            case 9:
                return "Logout";

            case 0:
                return "Exit";

            default:
                return "Invalid";
        }
    }

    public static void runTests() {

        System.out.println("=================================");
        System.out.println("        MENU TESTING");
        System.out.println("=================================");

        for (int i = 0; i <= 9; i++) {

            System.out.println(
                    "Choice " + i +
                            ": " +
                            getMenuName(i)
            );
        }
    }
}