public class PracBank{

    // Here we declare two private variables, accountOne and accountTwo,  
    // as instances (objects) of the PracCheckingAccount class.   
    private PracCheckingAccount accountOne;
    private PracCheckingAccount accountTwo;
   
    // Using the PracBank constructer we can initialize the new accounts.
    public PracBank(){
        accountOne = new PracCheckingAccount("Zeus", 100, "1");
        accountTwo = new PracCheckingAccount("Hades", 200, "2");
   }
   
    // This method is a getter that returns the balance of accountOne  
    // by calling its getBalance() method. 
    public int getAccountOneBalance() {
        return accountOne.getBalance();
   }

    // This method is a setter that allows us to set the balance of accountOne  
    // by calling its setBalance() method.  
    public void setAccountOneBalance(int newBalance) {
        accountOne.setBalance(newBalance);
   }

    // This method is a getter that returns the monthly interest of accountOne  
    // by calling its getMonthlyInterest() method.   
    public double getAccountOneMonthlyInterest(){
        return accountOne.getMonthlyInterest();
   }

    // This method is a getter that returns the balance of accountTwo  
    // by calling its getBalance() method.
    public int getAccountTwoBalance(){
        return accountTwo.getBalance();
   }

    // This method is a setter that allows us to set the balance of accountTwo  
    // by calling its setBalance() method.
    public void setAccountTwoBalance(int newBalance) {
        accountTwo.setBalance(newBalance);
   }

    // This method is a getter that returns the monthly interest of accountTwo  
    // by calling its getMonthlyInterest() method. 
    public double getAccountTwoMonthlyInterest(){
        return accountTwo.getMonthlyInterest();
   }
}
