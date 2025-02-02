import java.util.ArrayList;
public class PracPrimeDirective{



    // This method checks whether a number is prime and returns the result as a boolean.
    // Before running the loop, check if 'number' is less than 2.
    // Prime numbers must be 2 or greater. If 'number' is less than 2, return false.
    // This loop checks if 'number' is divisible by any number from 2 to n-1.
    // Prime numbers are only divisible by 1 and themselves.
    // We start at 2 since every number is divisible by 1.
    // The loop stops at 'number' to avoid checking if 'number' is divisible by itself.
    // If 'number' is divisible by 'i', it is not a prime number.
    // If no divisors were found, 'number' is a prime number.

    public boolean isPrime(int number) {
        if (number < 2) {
            return false;
    }
        for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                return false;
            }
    }
        return true;
}

    // This method takes an array of numbers passed from the main method.
    // It creates a new ArrayList called 'primes' to store prime numbers found from the 'numbers' array.
    // Then, we use a for-each loop to iterate over each number in the 'numbers' array.
    // Inside the loop, we use an if statement to check if the number is prime by passing it to the 'isPrime' method.
    // If the number is prime, it is added to the 'primes' ArrayList.
    // Finally, we return the 'primes' ArrayList containing all the prime numbers.

    public ArrayList<Integer> onlyPrimes(int[] numbers){
        ArrayList<Integer> primes = new ArrayList<Integer>();
        for (int number : numbers){
            if (isPrime(number)){
                primes.add(number);
            }
        }
        return primes;
    }

// This method uses a switch statement to handle even and odd numbers based on the 'action' parameter.
// The 'action' parameter determines which case will be triggered ('even' or 'odd').
// The 'array' parameter allows us to pass any array of integers to be processed.
// Once a case is chosen, a for-each loop will iterate through each number in the array.
// A number is even if it is divisible by 2, and odd if it is not.
    public void oddEven(String action, int[] array) {
        switch(action.toLowerCase()){
            case "even":
                System.out.print("Even Numbers: ");
                for (int number : array) {
                    if (number % 2 == 0){
                        System.out.print(number + " ");
                    }
                }
                System.out.println();
                break;
            case "odd":
                System.out.print("Odd Numbers: ");
                for (int number : array) {
                    if (number % 2 != 0){
                        System.out.print(number + " ");
                    }
                }
                System.out.println();
                break;
            default:
                System.out.println("Invalid Action");
        }
    }


// This method takes an array 'numbers' and an integer 'n'.
// It creates a new ArrayList called 'primes'. Even though we have another 'primes' in a different method,
// each method has its own scope, so they do not interfere with each other.
// We then loop through each number in 'numbers'.
// If the number is prime (checked using the 'isPrime' method), it is added to 'primes'.
// If the size of 'primes' reaches 'n' (i.e., we've found 'n' primes), the loop breaks.
// Finally, the 'primes' ArrayList is returned.
    public ArrayList<Integer> firstNPrimes(int[] numbers, int n){
        ArrayList<Integer> primes = new ArrayList<Integer>();
        for (int number : numbers){
            if (isPrime(number)){
                primes.add(number);
                if (primes.size() == n) {
                    break;
                }
            }
        }
        return primes;
    }

    public static void main(String[] args){
        System.out.println("init test");
        int[] numbers = {6, 29, 28, 33, 11, 100, 101, 43, 89};
        int[] newNumbers = {98, 57, 29, 22, 198, 746, 209, 57, 10, 6, 999, 77, 381, 88, 209, 780,};
        PracPrimeDirective pd = new PracPrimeDirective();
        System.out.println(pd.isPrime(10));
        System.out.println(pd.isPrime(7));
        System.out.println(pd.isPrime(1));
        System.out.println(pd.isPrime(2));
        System.out.println(pd.onlyPrimes(numbers));
        pd.oddEven("even", newNumbers);
        pd.oddEven("odd", newNumbers);
        System.out.println(pd.firstNPrimes(numbers, 1));
        System.out.println(pd.firstNPrimes(numbers, 3));
    }
}
