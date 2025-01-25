public class Main{
  public static void main(String[] args){
    Bank bankOfGods = new Bank();

// The print Statements that have been commented out are the original statements that do not work when the accounts are set to private the accounts must be set to public.

   /* System.out.println(bankOfGods.accountOne.getBalance());
    bankOfGods.accountOne.setBalance(5000);
    System.out.println(bankOfGods.accountOne.getBalance());
    System.out.println(bankOfGods.accountOne.getMonthlyInterest()); */

// The statements below are how we bypass the privacy of the accounts so we can print and alter the balance without changing the accounts to public

    System.out.println(bankOfGods.getAccountOneBalance());
    bankOfGods.setAccountOneBalance(5000);
    System.out.println(bankOfGods.getAccountOneBalance());
    System.out.println(bankOfGods.getAccountOneMonthlyInterest());
    // AccountTwo statements
    System.out.println(bankOfGods.getAccountTwoBalance());
    bankOfGods.setAccountTwoBalance(2000);
    System.out.println(bankOfGods.getAccountTwoBalance());
    System.out.println(bankOfGods.getAccountTwoMonthlyInterest());
    
  }
}
