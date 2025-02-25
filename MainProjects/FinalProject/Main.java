
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Creating a Scanner object to accept user input from the console
        Scanner scanner = new Scanner(System.in);

        // Creating an instance of UserAccounts to manage registered users
        UserAccounts userAccounts = new UserAccounts();

        // Infinite loop to keep the menu running until the user chooses to exit
        while (true) {
            System.out.println("\n==== CRYPTO COOKIES ====");
            System.out.println("[1] Register a new account");
            System.out.println("[2] Login to an existing account");
            System.out.println("[3] Exit");
            System.out.println("Choose an option: ");

            // Ensures input is available before attempting to read
            if (scanner.hasNextLine()) {

                // Reads user input from the console
                String choice = scanner.nextLine();

                switch (choice) {

                    case "1":
                        // Registers a new user
                        System.out.print("Enter new username: ");
                        String newUsername = scanner.nextLine();

                        System.out.print("Enter new PIN: ");
                        String newPin = scanner.nextLine();

                        // Calls the registerUser method to store the new user
                        userAccounts.registerUser(newUsername, newPin);
                        break;

                    case "2":
                        // Handles user login
                        System.out.print("Enter username: ");
                        String loginUsername = scanner.nextLine();

                        System.out.print("Enter PIN: ");
                        String loginPin = scanner.nextLine();

                        // Creates an instance of the Login class to authenticate the user
                        Login login = new Login(userAccounts);
                        boolean loggedIn = login.authenticate(loginUsername, loginPin);

                        // If login is successful, proceed to user menu
                        if (loggedIn) {
                            showUserMenu(scanner, userAccounts, loginUsername);
                        }
                        break;

                    case "3":
                        // Exits the application safely
                        System.out.println("Exiting CryptoCookies...");
                        scanner.close();
                        System.exit(0);

                    default:
                        // Displays an error message for invalid input
                        System.out.println("Invalid option. Please choose 1, 2, or 3.");
                }

            } else {
                // Handles cases where no input is detected and exits the program
                System.out.println("No input detected, exiting...");
                break;
            }
        }
    }

    /**
     * Displays the user menu after successful login and processes user actions.
     *
     * @param scanner      Scanner object for user input
     * @param userAccounts Instance of UserAccounts to access user data
     * @param username     The username of the logged-in user
     */
    private static void showUserMenu(Scanner scanner, UserAccounts userAccounts, String username) {
        // Retrieves the wallet associated with the logged-in user
        UserWallet userWallet = userAccounts.getWallets().get(username);

        // Loop to keep the user menu active until the user chooses to log out
        while (true) {
            System.out.println("\n==== USER MENU ====");
            System.out.println("[1] Wallet");
            System.out.println("[2] Swap");
            System.out.println("[3] Projections");
            System.out.println("[4] Deposit");
            System.out.println("[5] Withdraw");
            System.out.println("[6] NFT Collection");
            System.out.println("[7] Logout");

            // Reads the user's menu choice
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    // Displays the user's wallet details
                    if (userWallet != null) {
                        userWallet.displayWallet();
                    } else {
                        System.out.println("No wallet found for user: " + username);
                    }
                    break;

                case "2":
                    // Handles cryptocurrency swapping
                    if (userWallet != null) {
                        System.out.print("Enter the currency you want to swap from: ");
                        String fromCurrency = scanner.nextLine();

                        System.out.print("Enter the currency you want to swap to: ");
                        String toCurrency = scanner.nextLine();

                        System.out.print("Enter the amount in USD to swap: ");
                        double amountInUSD = Double.parseDouble(scanner.nextLine());

                        // Calls the swapCurrency method to execute the swap
                        Swap swap = new Swap(userWallet, userAccounts);
                        swap.swapCurrency(fromCurrency, toCurrency, amountInUSD);
                    } else {
                        System.out.println("No wallet found for user: " + username);
                    }
                    break;

                case "3":
                    // Calculates future projections based on the user's balance
                    if (userWallet != null) {
                        System.out.print("Enter the number of months for projection: ");
                        int months = Integer.parseInt(scanner.nextLine());

                        // Calls the calculateProjections method to generate projections
                        Projections projections = new Projections(userWallet);
                        projections.calculateProjections(months);
                    } else {
                        System.out.println("No wallet found for user: " + username);
                    }
                    break;

                case "4":
                    // Handles deposits into the user's wallet
                    System.out.print("Enter currency: ");
                    String currency = scanner.nextLine();

                    System.out.print("Enter amount in USD: ");
                    double amountInUSD = Double.parseDouble(scanner.nextLine());

                    // Calls the deposit method to add funds
                    userWallet.deposit(currency, amountInUSD, username, userAccounts);
                    userAccounts.saveAccounts();
                    break;

                case "5":
                    // Handles withdrawals from the user's wallet
                    if (userWallet != null) {
                        System.out.print("Enter the currency you want to withdraw from (USDT, BTC, XRP): ");
                        String fromCurrencyWithdraw = scanner.nextLine();

                        System.out.print("Enter the amount in USD to withdraw: ");
                        double amountInUSDWithdraw = Double.parseDouble(scanner.nextLine());

                        // Calls the withdrawCurrency method to process the withdrawal
                        Withdraw withdraw = new Withdraw(userWallet);
                        withdraw.withdrawCurrency(fromCurrencyWithdraw, amountInUSDWithdraw, username, userAccounts);

                        // Saves updated user data after the withdrawal
                        userAccounts.saveAccounts();
                    } else {
                        System.out.println("No wallet found for user: " + username);
                    }
                    break;

                case "6":
                    // Displays the NFT Collection menu
                    NFTCollection nftCollection = new NFTCollection();
                    nftCollection.showNFTMenu(scanner);
                    break;

                case "7":
                    // Logs the user out and returns to the main menu
                    System.out.println("Logging out...");
                    return;

                default:
                    // Displays an error message for invalid input
                    System.out.println("Invalid option. Please choose 1, 2, 3, 4, 5, 6, or 7.");
            }
        }
    }
}

