
import java.util.Map;

public class LmnhSwap {

    private LmnhUserWallet userWallet;

    private LmnhUserAccounts userAccounts;

    private Map<String, Double> conversionRates;

    public LmnhSwap(LmnhUserWallet userWallet, LmnhUserAccounts userAccounts) {
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

        double amountToAdd = amountInUSD * conversionRates.get(toCurrency);

        userWallet.updateBalance(fromCurrency, -amountToDeduct);
        
        userWallet,updateBalance(toCurrency, amountToAdd);

        System.out.printf("Successfully swapped %.2f %s to %.6f %s%n", amountToDeduct, fromCurrency, amountToAdd, toCurrency);

        userAccounts.saveAccounts();
        
    }
}
