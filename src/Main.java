import Finance.Finance_Management;
import Login.LoginSystem;
import Login.Register;
import Login.User;
import MainMenu.MainMenu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create a styled welcome header
        System.out.println("******************************************");
        System.out.println("*      Welcome to Myself Finance App!     *");
        System.out.println("*                                        *");
        System.out.println("******************************************");

        boolean loggedIn = false;

        Scanner scanner = new Scanner(System.in);

        while (!loggedIn) {
            System.out.println("\nChoose an option to proceed:");
            System.out.println("1. \u001B[34mLog in\u001B[0m");
            System.out.println("2. \u001B[32mRegister\u001B[0m");
            System.out.println("3. \u001B[31mExit\u001B[0m");
            System.out.print("Enter your choice: ");

            int input = scanner.nextInt();

            if (input == 2) {
                Register register = new Register();
                register.register();
            } else if (input == 1) {
                Scanner loginScanner = new Scanner(System.in);
                System.out.println("\n******************************************");
                System.out.println("*        \u001B[34mLog In to Your Account\u001B[0m        *");
                System.out.println("******************************************");

                System.out.print("Enter \u001B[33musername\u001B[0m: ");
                String username = loginScanner.nextLine();
                System.out.print("Enter \u001B[33mpassword\u001B[0m: ");
                String password = loginScanner.nextLine();

                User loginUser = new User(username, password);

                LoginSystem loginSystem = new LoginSystem(loginUser);

                if (loginSystem.checkAccount() && loginSystem.checkPassword()) {
                    loggedIn = true;
                    User user = loginSystem.login();

                    // Styled welcome message
                    System.out.println("\n******************************************");
                    System.out.println("*   Welcome, \u001B[36m" + user.getUsername() + "\u001B[0m!   *");
                    System.out.println("*  You can now manage your finances.   *");
                    System.out.println("******************************************");

                    MainMenu menu = new MainMenu(loginUser);
                    menu.run();

                    System.out.println("\nLogging out...");
                } else {
                    System.out.println("\n******************************************");
                    System.out.println("*        \u001B[31mLogin Failed! Try again.\u001B[0m      *");
                    System.out.println("******************************************");
                }
            } else if (input == 3) {
                System.out.println("\nExiting Myself Finance App...");
                System.exit(0);
            } else {
                System.out.println("\n\u001B[31mInvalid input. Please try again.\u001B[0m");
            }
        }
    }
}
