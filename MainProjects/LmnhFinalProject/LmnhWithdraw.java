import java.util.Map;

public class LmnhWithdraw {

    private LmnhUserWallet userWallet;
    private Map<String, Double> conversionRates;

    public LmnhWithdraw(LmnhUserWallet userWallet) {
        this.userWallet = userWallet;
        this.conversionRates = Map.of(
                "USDT", 1.00,
                "XRP", 0.39,
                "BTC", 0.000010
                );
    }

    public void withdrawCurrency(String fromCurrency, double amountInUSD, String username, LmnhUserAccounts userAccounts) {

        LmnhUserWallet userWallet = userAccounts.wallets.get(username);
        if (userWallet == null) {
            System.out.println("Error: No wallet found for user " + username);
            return;
        }

        if (!conversionRates.containsKey(fromCurrency)) {
            System.out.println("Invalid currency selection.");
            return;
        }

        double fromBalance = userWallet.getBalance(fromCurrency);
        double conversionRate = conversionRates.get(fromCurrency);

        double amountToDeduct = amountInUSD * conversionRate;

        if (fromBalance < amountToDeduct) {
            System.out.printf("Insufficient funds. You only have %.2f USD worth of %s.%n", fromBalance / conversionRate, fromCurrency);
            return;
        }

        userWallet.updateBalance(fromCurrency, -amountToDeduct);

        userAccounts.wallets.put(username, userWallet);
        userAccounts.saveAccounts();

        System.out.printf("Successfully withdrew %.2f USD worth of %s (%.6f %s deducted).%n", amountInUSD, fromCurrency, amountToDeduct, fromCurrency);
    }

}
