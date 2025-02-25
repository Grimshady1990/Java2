
import java.util.Map;

public class Swap {
    // User's wallet containing balances for different currencies
    private UserWallet userWallet;
    
    // User's accounts to manage and save changes
    private UserAccounts userAccounts;
    
    // A map storing the conversion rates for different currencies
    private Map<String, Double> conversionRates;

    /**
     * Constructor to initialize the Swap class with user wallet and accounts.
     * It also sets predefined conversion rates for supported currencies.
     *
     * @param userWallet   The user's wallet containing balances.
     * @param userAccounts The user's account information.
     */
    public Swap(UserWallet userWallet, UserAccounts userAccounts) {
        this.userWallet = userWallet;
        this.userAccounts = userAccounts;
        
        // Define conversion rates (relative to USD)
        this.conversionRates = Map.of(
            "USDT", 1.0,       // 1 USDT = 1 USD
            "XRP", 0.39,       // 1 XRP = 0.39 USD
            "BTC", 0.000010    // 1 BTC = 0.000010 USD
        );
    }

    /**
     * Swaps a specified amount (in USD) from one currency to another.
     *
     * @param fromCurrency  The currency to be swapped from.
     * @param toCurrency    The currency to be swapped to.
     * @param amountInUSD   The amount in USD to be converted.
     */
    public void swapCurrency(String fromCurrency, String toCurrency, double amountInUSD) {
        // Check if both currencies exist in the conversion rates map
        if (!conversionRates.containsKey(fromCurrency) || !conversionRates.containsKey(toCurrency)) {
            System.out.println("Invalid currency selection.");
            return;
        }

        // Get the current balance of the 'fromCurrency'
        double fromBalance = userWallet.getBalance(fromCurrency);
        
        // Calculate how much of 'fromCurrency' needs to be deducted 
        double amountToDeduct = amountInUSD * conversionRates.get(fromCurrency);

        // Check if the user has enough balance to proceed with the swap
        if (fromBalance < amountToDeduct) {
            System.out.println("Insufficient funds in " + fromCurrency + " wallet.");
            return;
        }

        // Calculate how much of 'toCurrency' will be added
        double amountToAdd = amountInUSD * conversionRates.get(toCurrency);
        
        // Deduct the amount from the 'fromCurrency' balance
        userWallet.updateBalance(fromCurrency, -amountToDeduct);
        
        // Add the equivalent amount to the 'toCurrency' balance
        userWallet.updateBalance(toCurrency, amountToAdd);

        // Print confirmation of the successful swap
        System.out.printf("Successfully swapped %.2f %s to %.6f %s%n", 
                          amountToDeduct, fromCurrency, amountToAdd, toCurrency);

        // Save the updated account balances
        userAccounts.saveAccounts();
    }
}

