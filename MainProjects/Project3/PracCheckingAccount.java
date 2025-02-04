public class PracCheckingAccount{

    // These private variables cannot be accessed directly outside this class.  
    // Instead of making them public, we will use getters and setters  
    // to provide controlled access from other classes.
    private String name;
    private int balance;
    private String id;
    private double interestRate;

    // This method is the initial stage of opening a new account.  
    // It takes all the necessary account information as its parameters.     
    public PracCheckingAccount(String inputName, int inputBalance, String inputId){
        this.name = inputName;
        this.balance = inputBalance;
        this.id = inputId;
        this.interestRate = 0.02;
    }
    // This method returns the balance of the current account.    
    public int getBalance(){
        return this.balance;
    }

    // This method updates the account balance by setting this.balance to the new balance.   
    public void setBalance(int newBalance){
        this.balance = newBalance;
    }

    // This method calculates and returns the monthly interest  
    // by multiplying the interest rate with the account balance.    
    public double getMonthlyInterest(){
        return this.interestRate * this.balance;
    }
}
