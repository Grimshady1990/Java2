import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        UserAccounts userAccounts = new UserAccounts();

        while (true) {

            System.out.println("\n==== CRYPTO COOKIES ====");
            System.out.println("[1] Register a new account");
            System.out.println("[2] Login to an existing account");
            System.out.println("[3] Exit");
            System.out.println("Choose an option: ");

            if (scanner.hasNextLine()) {

            String choice = scanner.nextLine();

            switch (choice) {
                
                case "1":
                    System.out.print("Enter new username: ");
                    String newUsername = scanner.nextLine();

                    System.out.print("Enter new PIN: ");
                    String newPin = scanner.nextLine();

                    userAccounts.registerUser(newUsername, newPin);
                    break;

                case "2":
                    System.out.print("Enter username: ");
                    String loginUsername = scanner.nextLine();

                    System.out.print("Enter PIN: ");
                    String loginPin = scanner.nextLine();

                    Login login = new Login(userAccounts);
                    login.authenticate(loginUsername, loginPin);
                    break;

                case "3":
                    System.out.println("Exiting CryptoCookies...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid option. Please choose 1, 2, or 3.");

            }
            
            } else {

                System.out.println("No input detected, exiting...");
                break;

            }
    }
    }
}
