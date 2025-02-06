public class PracATM {

    public static int totalMoney = 0;
    public static int numATMs = 0;
    public String name;
    public int money;

    public PracATM(int inputMoney, String nameATM) {
        name = nameATM;
        this.money = inputMoney;
        numATMs += 1;
        totalMoney += inputMoney;
    }

    public String toString(){
        return this.name + " has been deployed! The machine has been initalized with $" + this.money + ".";
    }

    public void withdrawMoney(int amountToWithdraw) {

        if (amountToWithdraw <= this.money) {
            this.money -= amountToWithdraw;
            totalMoney -= amountToWithdraw;
            System.out.println("WITHDRAWAL APPROVED! $" + amountToWithdraw + " has been withdrawn from " + this.name + ".");
            System.out.println(this.name + " has $" + this.money + " remaining.");
        }
        else {

            System.out.println("WITHDRAWAL FAILED! " + this.name + " only has $" + this.money + " remaining.");
        }
    }

    public void depositMoney(int amountDeposited) {

        this.money += amountDeposited;
        totalMoney += amountDeposited;
        System.out.println("DEPOSIT SUCCESSFUL! $" + amountDeposited + " has been deposited into " + this.name + ".");
        System.out.println(this.name + " now has $" + this.money + " available.");
    }

    public static void averageMoney() {
        System.out.println("The average amount in all your machines is currently $" + totalMoney / numATMs);
    }

    public static void totalATMs() {
        System.out.println("There is currently " + numATMs + " of your machines operational.");
    }

    public static void totalMoneyMeth() {
        System.out.println("There is a total of $" + totalMoney + " distributed between your machines.");
    }

    public static void main(String[] args) {

        PracATM firstATM = new PracATM(1000, "ATM001");
        System.out.println(firstATM);
        PracATM.averageMoney();
        PracATM.totalATMs();
        PracATM.totalMoneyMeth();
        PracATM secondATM = new PracATM(5000, "ATM002");
        firstATM.withdrawMoney(1001);
        firstATM.withdrawMoney(500);
        firstATM.depositMoney(10000);
        System.out.println(secondATM);
        PracATM.averageMoney();
        PracATM.totalATMs();
        PracATM.totalMoneyMeth();

    }
}
