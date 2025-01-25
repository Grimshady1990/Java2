public class Bank{
  private CheckingAccount accountOne;
  private CheckingAccount accountTwo;
  
  public Bank(){
    accountOne = new CheckingAccount("Zeus", 100, "1");
    accountTwo = new CheckingAccount("Hades", 200, "2");
  }
  //Below are the getter and setter's that I have added to help us bypass the account privacy
  public int getAccountOneBalance(){
    return accountOne.getBalance();
  }
  
  public void setAccountOneBalance(int newBalance) {
    accountOne.setBalance(newBalance);
  }
  public double getAccountOneMonthlyInterest(){
    return accountOne.getMonthlyInterest();
  }
  public int getAccountTwoBalance(){
    return accountTwo.getBalance();
  }
  
  public void setAccountTwoBalance(int newBalance) {
    accountTwo.setBalance(newBalance);
  }
  public double getAccountTwoMonthlyInterest(){
    return accountTwo.getMonthlyInterest();
  }
}
