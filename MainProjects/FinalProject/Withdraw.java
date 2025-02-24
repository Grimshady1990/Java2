import java.util.Map;

public class Withdraw {
    private UserWallet userWallet;
    private Map<String, Double> conversionRates;

    public Withdraw(UserWallet userWallet) {
        this.userWallet = userWallet;
        this.conversionRates = Map.of(
                "USDT", 1.00,
                "XRP", 0.39,
                "BTC", 0.000010
                );


    }

public void withdrawCurrency(String fromCurrency, double amountInUSD, String username, UserAccounts userAccounts) {
    // Retrieve the user's wallet based on their username
    UserWallet userWallet = userAccounts.wallets.get(username);
    if (userWallet == null) {
        System.out.println("Error: No wallet found for user " + username);
        return;
    }

    // Check if the currency is valid
    if (!conversionRates.containsKey(fromCurrency)) {
        System.out.println("Invalid currency selection.");
        return;
    }

    // Get the balance and conversion rate for the selected currency
    double fromBalance = userWallet.getBalance(fromCurrency);
    double conversionRate = conversionRates.get(fromCurrency);
    
    // Convert USD to crypto equivalent
    double amountToDeduct = amountInUSD * conversionRate;

    // Check if the user has sufficient funds
    if (fromBalance < amountToDeduct) {
        System.out.printf("Insufficient funds. You only have %.2f USD worth of %s.%n", fromBalance / conversionRate, fromCurrency);
        return;
    }

    // Deduct the converted amount from the user's wallet
    userWallet.updateBalance(fromCurrency, -amountToDeduct);

    // Ensure the wallet updates are persisted
    userAccounts.wallets.put(username, userWallet);
    userAccounts.saveAccounts();

    // Output success message
    System.out.printf("Successfully withdrew %.2f USD worth of %s (%.6f %s deducted).%n",
            amountInUSD, fromCurrency, amountToDeduct, fromCurrency);
}

}


    
