public class LmnhATM {

    static public int totMoney;
    static public int totATM;

    public int money;
    public String name;


    public LmnhATM(int inputCash, String inputName) {
        this.money += inputCash;
        this.name = inputName;
        totMoney += inputCash;
        totATM++;
    }

    public String toString() {
        return this.name + " Initialized! The machine has $" + this.money + " available.";

    }

    public void withdrawCash(int withdrawAmount) {

        if (withdrawAmount <= this.money) {
            this.money -= withdrawAmount;
            totMoney -= withdrawAmount;
            System.out.println("WITHDRAWAL SUCCESSFUL: You have withdrawn $" + withdrawAmount + " From " + this.name + ". This machine now has $" + this.money + " available." );
        }
        else {
            System.out.println("WITHDRAWAL FAILURE! This machine does not have enough inventory to complete the withdrawal");
        }
    }

    public void depositCash(int depositAmount) {
        this.money += depositAmount;
        totMoney += depositAmount;
        System.out.println("DEPOSIT SUCCESSFUL! $" + depositAmount + " was deposited into " + this.name + ". There is now $" + this.money + " available." );
    }

    public static void statReport() {
        System.out.println("GRAND TOTAL $" + totMoney);
        System.out.println("AVERAGE $" + totMoney / totATM);
        System.out.println("TOTAL MACHINES: " + totATM);
    }
        
    public static void main(String[] args) {


        LmnhATM ATM001 = new LmnhATM(5000, "ATM001");

        System.out.println(ATM001);
        ATM001.withdrawCash(6000);
        ATM001.withdrawCash(1000);
        ATM001.depositCash(1000);
        LmnhATM ATM002 = new LmnhATM(10000, "ATM002");
        System.out.println(ATM002);
        statReport();
    }

}
