
public class LmnhATM {
    
    public static int totATM;
    public static int totMoney;

    public int money;
    public String name;

    public LmnhATM(int inputMoney, String inputName) {

        this.money += inputMoney;
        totMoney += inputMoney;
        this.name = inputName;
        totATM++;

    }

    public String toString() {
        return this.name + " has been initalized with $" + this.money + ".";
    }

    public void withdrawMoney(int withdrawAmount) {

        if (withdrawAmount <= this.money) {
            this.money -= withdrawAmount;
            totMoney -= withdrawAmount;
            System.out.println("WITHDRAWAL SUCCESSFUL! $" + withdrawAmount + " has been taken from " + this.name + ". There is now $" + this.money + " available.");
        }
        else {
            System.out.println("WITHDRAWAL FAILED! This machine does not have enough inventory to make the withdrawal.");
        }

    }

    public void depositMoney(int depositAmount) {
        this.money += depositAmount;
        totMoney += depositAmount;
        System.out.println("DEPOSIT SUCCESSFUL! $" + depositAmount + " has been added to " + this.name + ". There is now $" + this.money + " available.");
    }

    public static void statusReport() {
        System.out.println("GRAND TOTAL: $" + totMoney);
        System.out.println("AVERAGE: $" + totMoney / totATM);
        System.out.println("ACTIVE MACHINES: " + totATM);
    }

    public static void main(String[] args) {
        LmnhATM ATM001 = new LmnhATM(5000, "ATM001");
        System.out.println(ATM001);
        ATM001.withdrawMoney(6000);
        ATM001.withdrawMoney(3000);
        ATM001.depositMoney(3000);
        LmnhATM ATM002 = new LmnhATM(5000, "ATM002");
        System.out.println(ATM002);
        statusReport();
        LmnhATM ATM003 = new LmnhATM(10000, "ATM003");
        System.out.println(ATM003);
        statusReport();
    }
}
