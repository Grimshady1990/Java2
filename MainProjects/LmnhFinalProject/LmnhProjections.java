import javax.swing.DropMode;

public class LmnhProjections {

    private LmnhUserWallet userWallet;

    public LmnhProjections(UserWallet userWallet) {
        this.userWallet = userWallet;
    }


    public void calculateProjections(int months) {

        double totalBalance = userWallet.getTotalBalanceInUSD();
        double originalBalance = totalBalance;

        double totalProfit = 0;

        System.out.println("==== PROJECTION RESULTS ====");
        System.out.printf("Starting Balance: $%.2f\n", originalBalance);
        System.out.println("Breakdown");

        for (int i = 1; i <= months; i++) {

            double monthlyIncrease = totalBalance * 0.10;
            totalBalance += monthlyIncrease;
            totalProfit += monthlyIncrease;

            System.out.printf("Month %d: $%.2f\n", i, totalBalance);
        }

        System.out.printf("\nTotal Profit: $%.2f\n", totalProfit);
    }
}
