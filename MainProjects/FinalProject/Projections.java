
public class Projections {
    
    // Instance variable to store the user's wallet information
    private UserWallet userWallet;

    /**
     * Constructor that initializes the Projections class with a UserWallet instance.
     *
     * @param userWallet The user's wallet, which contains their balance and assets.
     */
    public Projections(UserWallet userWallet) {
        this.userWallet = userWallet;
    }

    /**
     * Calculates and displays future balance projections based on a 10% monthly increase.
     *
     * @param months The number of months for which to calculate the projections.
     */
    public void calculateProjections(int months) {
        // Get the user's total wallet balance in USD
        double totalBalance = userWallet.getTotalBalanceInUSD();
        double originalBalance = totalBalance; // Store the original balance for reference
        double totalProfit = 0; // Variable to track the accumulated profit

        // Display the initial balance and projection header
        System.out.println("==== PROJECTION RESULTS ====");
        System.out.printf("Starting Balance: $%.2f\n", originalBalance);
        System.out.println("Breakdown");

        // Loop through each month to calculate balance growth
        for (int i = 1; i <= months; i++) {
            // Calculate a 10% increase of the current total balance
            double monthlyIncrease = totalBalance * 0.10;
            totalBalance += monthlyIncrease; // Update balance with the increase
            totalProfit += monthlyIncrease;  // Accumulate profit over the months

            // Display the projected balance for the current month
            System.out.printf("Month %d: $%.2f\n", i, totalBalance);
        }

        // Display the total profit earned after the given months
        System.out.printf("\nTotal Profit: $%.2f\n", totalProfit);
    }
}

