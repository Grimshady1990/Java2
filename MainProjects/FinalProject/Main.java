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
                        showUserMenu(scanner, userAccounts, loginUsername);
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

   private static void showUserMenu(Scanner scanner, UserAccounts userAccounts, String username) {
        UserWallet userWallet = userAccounts.getWallets().get(username);
    while (true) {
        System.out.println("\n==== USER MENU ====");
        System.out.println("[1] Wallet");
        System.out.println("[2] Swap");
        System.out.println("[3] Projections");
        System.out.println("[4] Deposit");
        System.out.println("[5] Withdraw");
        System.out.println("[6] Logout");

        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                  
                if (userWallet != null) {
                    userWallet.displayWallet();
                } else {
                    System.out.println("No wallet found for user: " + username);
                }
                break;

            case "2":
                if (userWallet != null) {
                    System.out.print("Enter the currency you want to swap from: ");
                    String fromCurrency = scanner.nextLine();

                    System.out.print("Enter the currency you want to swap to: ");
                    String toCurrency = scanner.nextLine();

                    System.out.print("Enter the amount in USD to swap: ");
                    double amountInUSD = Double.parseDouble(scanner.nextLine());

                    Swap swap = new Swap(userWallet, userAccounts);
                    swap.swapCurrency(fromCurrency, toCurrency, amountInUSD);

                } else {
                    System.out.println("No Wallet found for user: " + username);
                }
                break;

            case "3":
                if (userWallet != null) {
                    System.out.print("Enter the number of months for projection: ");
                    int months = Integer.parseInt(scanner.nextLine());

                    Projections projections = new Projections(userWallet); 
                    projections.calculateProjections(months);
                } else {
                    System.out.println("No wallet found for user: " + username);
                }

                break;

            case "4":
                System.out.print("Enter currency: ");
                String currency = scanner.nextLine();

                System.out.print("Enter amount in USD: ");
                double amountInUSD = Double.parseDouble(scanner.nextLine());

                userWallet.deposit(currency, amountInUSD, username, userAccounts);
                userAccounts.saveAccounts();
                break;

                case "5":
                if (userWallet != null) {
                    System.out.print("Enter the currency you want to withdraw from (USDT, BTC, XRP): ");
                    String fromCurrencyWithdraw = scanner.nextLine();

                    System.out.print("Enter the amount in USD to withdraw: ");
                    double amountInUSDWithdraw = Double.parseDouble(scanner.nextLine());

                    Withdraw withdraw = new Withdraw(userWallet);
                    // Fix: Pass the correct variable names to the withdraw method
                    withdraw.withdrawCurrency(fromCurrencyWithdraw, amountInUSDWithdraw, username, userAccounts);

                    // Save the updated accounts after withdrawal
                    userAccounts.saveAccounts();
                } else {
                    System.out.println("No wallet found for user: " + username);
                }
                break;


                        case "6": 
                System.out.println("Logging out...");
                return;

            default:
                System.out.println("Invalid option. Please choose 1, 2, 3, 4, or 5.");
        }
    }
}

}
