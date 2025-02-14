public class LmnhCA {
    private int balance;
    private String name;
    private double intrestRate = 0.02;

    public LmnhCA(int inputBal, String inputName) {
        
        this.name = inputName;
        this.balance = inputBal;
        this.intrestRate = 0.02; 

    }
    
    public int getBalance() {
        return this.balance;
    }

    public void updateBalance(int amount) {
        this.balance = amount;
    }

    public double showIntrest() {
        return this.intrestRate * this.balance;
    }
}
