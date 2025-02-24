import java.util.Map;

public class Swap {
    private UserWallet userWallet;
    private UserAccounts userAccounts;
    private Map<String, Double> conversionRates;

    public Swap(UserWallet userWallet, UserAccounts userAccounts) {
        this.userWallet = userWallet;
        this.userAccounts = userAccounts;
        this.conversionRates = Map.of(
            "USDT", 1.0,
            "XRP", 0.39,
            "BTC", 0.000010
        );
    }

    public void swapCurrency(String fromCurrency, String toCurrency, double amountInUSD) {
    if (!conversionRates.containsKey(fromCurrency) || !conversionRates.containsKey(toCurrency)) {
        System.out.println("Invalid currency selection.");
        return;
    }

    // Get the balance of the currency to be swapped
    double fromBalance = userWallet.getBalance(fromCurrency);
    // Calculate how much to deduct in the 'fromCurrency' (amountInUSD * conversionRate of the 'fromCurrency')
    double amountToDeduct = amountInUSD * conversionRates.get(fromCurrency);

    if (fromBalance < amountToDeduct) {
        System.out.println("Insufficient funds in " + fromCurrency + " wallet.");
        return;
    }

    // Calculate how much to add in the 'toCurrency' (amountInUSD * conversionRate of the 'toCurrency')
    double amountToAdd = amountInUSD * conversionRates.get(toCurrency);
    
    // Update the balances
    userWallet.updateBalance(fromCurrency, -amountToDeduct);
    userWallet.updateBalance(toCurrency, amountToAdd);

    // Output the result
    System.out.printf("Successfully swapped %.2f %s to %.6f %s%n", amountToDeduct, fromCurrency, amountToAdd, toCurrency);

    userAccounts.saveAccounts();
    }
}
