import java.util.Scanner;

public class LmnhMain {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        LmnhUserAccounts lmnhUserAccounts = new LmnhUserAccounts();


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

                        LmnhLogin login = new LmnhLogin(userAccounts);
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
                        System.out.println("invalid option. Please choose 1, 2, or 3.");
                }
            } else {
                System.out.println("No input detected, exiting...");
                break;
            }
        }

        
    }

    private static void showUserMenu(Scanner scanner, LmnhUserAccounts userAccounts, String username) {

        LmnhUserWallet userWallet = userAccounts.getWallets().get(username);

        while (true) {
            System.out.println("\n==== USER MENU ====");
            System.out.println("[1] Wallet");
            System.out.println("[2] Swap");
            System.out.println("[3] Projections");
            System.out.println("[4] Deposit");
            System.out.println("[5] Withdraw");
            System.out.println("[6] NFT Collection");
            System.out.println("[7] Logout");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    if (userWallet != null) {
                        userWallet.displayWallet();
                    } else {
                        System.out.println("No wallet found for user " + username);
                    }
                    break;
                case "2":
                    if (userWallet != null) {
                        System.out.print("Enter the currency you want to swap from: ");
                        String fromCurrency = scanner.nextLine();

                        System.out.print("Enter the currency you want to swap to: ");
                        String toCurrency = scanner.nextLine();

                        System.out.print("Enter amount in USD to swap: ");
                        double amountInUSD = Double.parseDouble(scanner.nextLine());

                        LmnhSwap swap = new LmnhSwap(userWallet, userAccounts);
                        swap.swapCurrency(fromCurrency, toCurrency, amountInUSD);
                        
                    } else {
                        System.out.println("No Wallet found for user: " + username);
                    }
                    break;

                case "3":
                    if (userWallet != null) {
                        System.out.print("Enter the number of months for projections: ");
                        
                        int months = Integer.parseInt(scanner.nextLine());

                        Projections projections = new Projecttions(UserWallet);
                        projections.calculateProjections(months);
                    } else {
                        System.out.println("No wallet found for user: " + username);
                    }

                    break;

                case "4":

                    System.out.println("Enter currency");
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
                        withdraw.withdrawCurrency(fromCurrencyWithdraw, amountInUSDWithdraw, username, userAccounts);

                        userAccounts.saveAccounts();

                    } else {
                        System.out.println("No wallet found for user: " + username);
                    }
                    break;
                    
            }
        }
    }


}
