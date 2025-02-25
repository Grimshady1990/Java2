
import java.util.HashMap;
import java.util.Map;

public class UserWallet {

    // Stores balances for different currencies
    private Map<String, Double> balances;
    // Stores conversion rates for supported currencies
    private final Map<String, Double> conversionRates;

    public UserWallet() {
        // Initialize balances with default values
        balances = new HashMap<>();
        balances.put("USDT", 0.0);
        balances.put("XRP", 0.0);
        balances.put("BTC", 0.0);

        // Initialize conversion rates for each currency
        conversionRates = new HashMap<>();
        conversionRates.put("USDT", 1.0);   // USDT is pegged to USD
        conversionRates.put("XRP", 0.39);  // Example conversion rate
        conversionRates.put("BTC", 0.000010); // Example conversion rate
    }

    // Calculates the total balance in USD by converting all balances
    public double getTotalBalanceInUSD() {
        double totalUSD = 0.0;
        for (String currency : balances.keySet()) {
            double cryptoAmount = balances.get(currency);
            double usdValue = cryptoAmount / conversionRates.get(currency);
            totalUSD += usdValue;
        }
        return totalUSD;
    }

    // Returns the conversion rates
    public Map<String, Double> getConversionRates() {
        return conversionRates;
    }

    // Handles deposits by converting the USD amount into the target currency
    public void deposit(String currency, double amountInUSD, String username, UserAccounts userAccounts) {
        if (balances.containsKey(currency)) {
            // Convert USD to the selected cryptocurrency
            double convertedAmount = amountInUSD * conversionRates.get(currency);
            balances.put(currency, balances.get(currency) + convertedAmount);
            System.out.printf("Deposited $%.2f, converted to %.6f %s%n", amountInUSD, convertedAmount, currency);

            // Ensure the correct wallet is updated for the user
            UserWallet userWallet = userAccounts.wallets.get(username);
            if (userWallet == null) {
                System.out.println("Error: No wallet found for user " + username);
                return;
            }

            // Copy the updated balance to the user's wallet
            userWallet.balances.putAll(this.balances);

            // Save the updated wallet data
            userAccounts.wallets.put(username, userWallet);
            userAccounts.saveAccounts();
        } else {
            System.out.println("Invalid currency.");
        }
    }

    // Retrieves the balance of a specific currency
    public double getBalance(String currency) {
        return balances.getOrDefault(currency, 0.0);
    }

    // Updates the balance of a specific currency (used for transactions)
    public void updateBalance(String currency, double amount) {
        double currentBalance = balances.getOrDefault(currency, 0.0);
        balances.put(currency, currentBalance + amount);
    }

    // Returns all balances in the wallet
    public Map<String, Double> getBalances() {
        return balances;
    }

    // Converts the wallet balances into a string format for saving
    public String getWalletAsString() {
        StringBuilder walletString = new StringBuilder();
        for (String currency : balances.keySet()) {
            walletString.append(currency)
                        .append("=")
                        .append(balances.get(currency))
                        .append(";");
        }
        return walletString.toString();
    }

    // Loads wallet balances from a saved string format
    public void loadWalletFromString(String walletData) {
        String[] currencyData = walletData.split(";");
        for (String data : currencyData) {
            if (data.length() > 0) {
                String[] parts = data.split("=");
                if (parts.length == 2) {
                    String currency = parts[0].trim();
                    String balanceString = parts[1].trim();
                    double balance = 0.0;
                    try {
                        balance = Double.parseDouble(balanceString);
                    } catch (NumberFormatException e) {
                        System.out.println("Error parsing balance for " + currency + ": " + balanceString);
                        continue;
                    }
                    balances.put(currency, balance);
                }
            }
        }
    }

    // Displays the wallet's balance for each currency and its equivalent USD value
    public void displayWallet() {
        if (balances.isEmpty()) {
            System.out.println("No wallet data available.");
            return;
        }

        System.out.println("\n==== WALLET BALANCE ====");
        double totalUSD = 0.0;
        for (String currency : balances.keySet()) {
            double cryptoAmount = balances.get(currency);
            double usdValue = cryptoAmount / conversionRates.get(currency);
            totalUSD += usdValue;
            System.out.printf("%s: %.6f (Worth: $%.2f)%n", currency, cryptoAmount, usdValue);
        }
        System.out.printf("\nTotal Portfolio Value: $%.2f%n", totalUSD);
    }
}

