import java.util.HashMap;
import java.util.Map;

public class UserWallet {

    private Map<String, Double> balances;
    private final Map<String, Double> conversionRates;



    public UserWallet() {

    balances = new HashMap<>();
    balances.put("USDT", 0.0);
    balances.put("XRP", 0.0);
    balances.put("BTC", 0.0);

    conversionRates = new HashMap<>();
    conversionRates.put("USDT", 1.0);
    conversionRates.put("XRP", 0.39);
    conversionRates.put("BTC", 0.000010);

    }


    public double getTotalBalanceInUSD() {
        double totalUSD = 0.0;
        for (String currency : balances.keySet()) {
            double cryptoAmount = balances.get(currency);
            double usdValue = cryptoAmount / conversionRates.get(currency);
            totalUSD += usdValue;
        }
        return totalUSD;
    }

    public Map<String, Double> getConversionRates() {
        return conversionRates;
    }

    public void deposit(String currency, double amountInUSD, String username, UserAccounts userAccounts) {
        if (balances.containsKey(currency)) {
            double convertedAmount = amountInUSD * conversionRates.get(currency);
            balances.put(currency, balances.get(currency) + convertedAmount);
            System.out.printf("Deposited $%.2f, converted to %.6f %s%n", amountInUSD, convertedAmount, currency);
            System.out.println("🔄 Updated Wallet Balances: " + balances);

            // 🔎 Ensure we get the correct wallet for the user
        UserWallet userWallet = userAccounts.wallets.get(username);
        if (userWallet == null) {
            System.out.println("Error: No wallet found for user " + username);
            return;
        }

        // ✅ Copy the new balance to the user's wallet
        userWallet.balances.putAll(this.balances);

        // Now save the updated wallet
        userAccounts.wallets.put(username, userWallet);
        userAccounts.saveAccounts();


        } else {
            System.out.println("Invalid currency.");
        }
    }

    public double getBalance(String currency) {
        return balances.getOrDefault(currency, 0.0);

    }

    public void updateBalance(String currency, double amount) {
        double currentBalance = balances.getOrDefault(currency, 0.0);
        balances.put(currency, currentBalance + amount);
    }

    public Map<String, Double> getBalances() {
        return balances;
    }

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

    public void loadWalletFromString(String walletData) {
    System.out.println("Loading wallet data: " + walletData); // Debug print
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
                System.out.println("✅ Loaded: " + currency + " = " + balance);  // Debug print
            }
        }
    }
    System.out.println("Balances after loading wallet: " + balances);  // Debug print
}


    public void displayWallet() {
        
        System.out.println("Balances map: " + balances);

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




        // Load wallet balances from a string format
        

}
