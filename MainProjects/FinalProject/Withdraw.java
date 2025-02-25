
import java.util.Map;

public class Withdraw {
    // References to user wallet and conversion rates
    private UserWallet userWallet;
    private Map<String, Double> conversionRates;

    // Constructor initializes the user wallet and sets conversion rates
    public Withdraw(UserWallet userWallet) {
        this.userWallet = userWallet;
        this.conversionRates = Map.of(
                "USDT", 1.00,   // 1 USDT = 1 USD
                "XRP", 0.39,    // 1 XRP = 0.39 USD
                "BTC", 0.000010 // 1 BTC = 0.000010 USD
        );
    }

    // Method to withdraw a specified amount in USD from a user's wallet
    public void withdrawCurrency(String fromCurrency, double amountInUSD, String username, UserAccounts userAccounts) {
        // Retrieve the user's wallet based on their username
        UserWallet userWallet = userAccounts.wallets.get(username);
        if (userWallet == null) {
            System.out.println("Error: No wallet found for user " + username);
            return; // Exit if the user has no wallet
        }

        // Check if the requested currency exists in the conversion rates
        if (!conversionRates.containsKey(fromCurrency)) {
            System.out.println("Invalid currency selection.");
            return; // Exit if the currency is invalid
        }

        // Get the current balance of the requested currency in the user's wallet
        double fromBalance = userWallet.getBalance(fromCurrency);
        double conversionRate = conversionRates.get(fromCurrency);

        // Convert the requested withdrawal amount from USD to crypto
        double amountToDeduct = amountInUSD * conversionRate;

        // Check if the user has enough balance to make the withdrawal
        if (fromBalance < amountToDeduct) {
            System.out.printf("Insufficient funds. You only have %.2f USD worth of %s.%n", fromBalance / conversionRate, fromCurrency);
            return; // Exit if the balance is too low
        }

        // Deduct the equivalent amount from the user's balance
        userWallet.updateBalance(fromCurrency, -amountToDeduct);

        // Save the updated wallet data
        userAccounts.wallets.put(username, userWallet);
        userAccounts.saveAccounts();

        // Output a success message with details of the transaction
        System.out.printf("Successfully withdrew %.2f USD worth of %s (%.6f %s deducted).%n",
                amountInUSD, fromCurrency, amountToDeduct, fromCurrency);
    }
}
   
