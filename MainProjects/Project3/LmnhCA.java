public class LmnhCA {

    private int balance;
    private String name;
    private double intrestRate;


    public LmnhCA(int inputBal, String inputName) {

        this.balance = inputBal;
        this.name = inputName;
        this.intrestRate = 0.02;

    }  

    public int getBalance() {

        return this.balance;
    }

    public void updateBalance(int amount) {
       this.balance = amount;
    }

    public double getInterest() {

        return intrestRate * this.balance;
    }


}
