public class PracATM {


// These are two static variables. Static variables belong to the class, meaning they have the same value for all instances of the class.
    public static int totalMoney = 0; // Total money across all instances
    public static int numATMs = 0;    // Number of ATM instances

// These are instance variables. Each instance has its own copy of these variables, meaning they store information specific to each object.
    public String name;  // Name of the ATM instance
    public int money;    // Money stored in this specific ATM instance

    
// This is the class constructor, which takes two parameters:
// - `inputMoney` sets the amount of money for the new instance and adds it to the static variable `totalMoney`, 
//   keeping a running total of money across all instances.
// - `nameATM` is used to assign a name to each ATM instance, which is stored in the `name` variable. 
//   We can then refer to the name of each instance using `this.name`.
//
// Additionally, each time a new instance is created, we increment the static variable `numATMs` 
// to keep track of the total number of ATM instances.
public PracATM(int inputMoney, String nameATM) {
    this.name = nameATM;
    this.money = inputMoney;
    numATMs += 1;           // Increment the number of ATM instances
    totalMoney += inputMoney; // Add the money from this instance to the total money
}

    
    // The `toString` method returns a string containing information about the instance, 
    // including the name and the amount of money the ATM has been initialized with.
    public String toString(){
        return this.name + " has been deployed! The machine has been initialized with $" + this.money + ".";
    }


    // The `withdrawMoney` method takes an integer `amountToWithdraw` as its parameter.
    // It attempts to withdraw the specified amount by decrementing both the instance variable `money`
    // and the static variable `totalMoney`. If the withdrawal is successful (i.e., the ATM has enough money),
    // it updates both values and prints a success message. If there are insufficient funds, it prints a failure message.
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



    // The `depositMoney` method takes an integer `amountDeposited` as its parameter.
    // It deposits the specified amount by incrementing both the instance variable `money`
    // and the static variable `totalMoney`. After the deposit, it prints a success message
    // along with the updated balance for the specific ATM instance.
    public void depositMoney(int amountDeposited) {

        this.money += amountDeposited;
        totalMoney += amountDeposited;
        System.out.println("DEPOSIT SUCCESSFUL! $" + amountDeposited + " has been deposited into " + this.name + ".");
        System.out.println(this.name + " now has $" + this.money + " available.");
    }


    // This is a static method that calculates and prints the average amount of money across all instances.
    // It divides the total money by the number of ATM instances to compute the average.
    public static void averageMoney() {
        System.out.println("The average amount in all your machines is currently $" + totalMoney / numATMs);
    }

    // This is a static method that prints the total number of ATM instances currently in operation.
    public static void totalATMs() {
        System.out.println("There is currently " + numATMs + " of your machines operational.");
    }

    // This is a static method that prints the total amount of money stored across all ATM instances.
    public static void totalMoneyMeth() {
        System.out.println("There is a total of $" + totalMoney + " distributed between your machines.");
    }

    public static void main(String[] args) {

        // Creation of the first instance
        PracATM firstATM = new PracATM(1000, "ATM001");

        // This prints the instance information by calling the `toString()` method on the object.
        System.out.println(firstATM);

        // This prints the average amount of money across all instances. Since it's a static method, it's called using the class name.
        PracATM.averageMoney();

        // This prints the total number of instances. Since it's a static method, it must be called using the class name.
        PracATM.totalATMs();

        // This prints the total amount of money in all instances. Again, since it's a static method, it must be called using the class name.
        PracATM.totalMoneyMeth();

        // Creation of the second instance
        PracATM secondATM = new PracATM(5000, "ATM002");

        // This withdraws 1001 from the `firstATM` instance to check if the `else` statement functions properly (assuming it's meant to handle an invalid withdrawal).
        firstATM.withdrawMoney(1001);

        // This withdraws 500 from `firstATM`, which will trigger the `if` statement (assuming it's for a valid withdrawal).
        firstATM.withdrawMoney(500);

        // This is how we deposit money into the instance.
        firstATM.depositMoney(10000);

        // This prints the instance information for the second instance by calling the `toString()` method.
        System.out.println(secondATM);

        // We print all static methods again to include the second instance and verify that everything is working correctly.
        PracATM.averageMoney();
        PracATM.totalATMs();
        PracATM.totalMoneyMeth();
    }
}
