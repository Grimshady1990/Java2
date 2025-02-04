public class PracMain{
    public static void main(String[] args) {


        // This creates a new instance of PracBank called bankOfGods.
        PracBank bankOfGods = new PracBank();

        // This prints the balance of accountOne using the getter method.
        System.out.println(bankOfGods.getAccountOneBalance());

        // This changes accountOne's balance using the setter method.
        bankOfGods.setAccountOneBalance(5000);

        // Reprints accountOne's balance to show the updated value after using the setter method.
        System.out.println(bankOfGods.getAccountOneBalance());

        // Prints accountOne's monthly interest using the getter method.
        System.out.println(bankOfGods.getAccountOneMonthlyInterest());

        // This prints the balance of accountTwo using the getter method.
        System.out.println(bankOfGods.getAccountTwoBalance());

        // This changes accountTwo's balance using the setter method.
        bankOfGods.setAccountTwoBalance(2000);

        // Reprints accountTwo's balance to show the updated value after using the setter method.
        System.out.println(bankOfGods.getAccountTwoBalance());

        // Prints accountTwo's monthly interest using the getter method.
        System.out.println(bankOfGods.getAccountTwoMonthlyInterest());
    }
}
