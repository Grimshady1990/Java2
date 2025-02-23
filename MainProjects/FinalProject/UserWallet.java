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

    public void deposit(String currency, double amountInUSD) {
        if (balances.containsKey(currency)) {
            double convertedAmount = amountInUSD * conversionRates.get(currency);
            balances.put(currency, balances.get(currency) + convertedAmount);
            System.out.printf("Deposited $%.2f, converted to %.6f %s%n", amountInUSD, convertedAmount, currency);
        } else {
            System.out.println("Invalid currency.");
        }
    }

    public double getBalance(String currency) {
        return balances.getOrDefault(currency, 0.0);

    }

    public Map<String, Double> getBalances() {
        return balances;
    }

    public void displayWallet() {

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
