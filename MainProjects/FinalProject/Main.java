import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        UserWallet userWallet = new UserWallet();
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
                    boolean loggedIn = login.authenticate(loginUsername, loginPin);

                    if (loggedIn) {
                        showUserMenu(scanner, userWallet, userAccounts, loginUsername);
                    }
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

    private static void showUserMenu(Scanner scanner, UserWallet userWallet, UserAccounts userAccounts, String username) {
        while (true) {
            System.out.println("\n==== USER MENU ====");
            System.out.println("[1] Wallet");
            System.out.println("[2] Swap");
            System.out.println("[3] Projections");
            System.out.println("[4] Deposit");
            System.out.println("[5] Logout");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    userWallet.displayWallet();
                    break;

                case "2":
                    System.out.println("Swap feature coming soon...");
                    break;

                case "3":
                    System.out.println("Projections feature coming soon...");
                    break;

                case "4":
                    System.out.print("Enter currency: ");
                    String currency = scanner.nextLine();  // Get the currency from user input

                    System.out.print("Enter amount in USD: ");
                    double amountInUSD = Double.parseDouble(scanner.nextLine());  // Get the amount in USD

    // Now call the deposit method on userWallet with the correct arguments
                    userWallet.deposit(currency, amountInUSD);  // Pass currency and amountInUSD
                    break;



                case "5": 
                    System.out.println("Logging out...");
                    return;

                default:
                    System.out.println("Invalid option. Please choose 1, 2, 3, 4, or 5.");
            }
        }
    }

}
