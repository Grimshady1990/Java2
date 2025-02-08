
import java.util.ArrayList;

public class PracPrimeDirective {

    // This method determines if a given number is prime.
    // A prime number is only divisible by 1 and itself.
    // If the number is less than 2, it cannot be prime, so we return false immediately.
    // We then check divisibility by every number from 2 up to (but not including) the given number.
    // If we find any number that divides evenly, the given number is not prime, so we return false.
    // If no divisors are found, the number is prime, so we return true.
    public boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i < number; i++) {
            if (number % i == 0) { // If number is divisible by i, it's not prime
                return false;
            }
        }
        return true; // If no divisors were found, it's prime
    }

    // This method filters an array of numbers, returning only the prime numbers.
    // It creates an ArrayList to store prime numbers.
    // The method iterates over each number in the given array.
    // If a number is prime (checked using isPrime), it gets added to the list.
    // Finally, the list of prime numbers is returned.
    public ArrayList<Integer> onlyPrimes(int[] numbers) {
        ArrayList<Integer> primes = new ArrayList<>();
        for (int number : numbers) {
            if (isPrime(number)) {
                primes.add(number);
            }
        }
        return primes;
    }

    // This method separates numbers into even or odd based on the provided action.
    // The 'action' parameter should be either "even" or "odd".
    // If "even", it prints all even numbers from the given array.
    // If "odd", it prints all odd numbers from the array.
    // If the action is invalid, it prints an error message.
    public void oddEven(String action, int[] array) {
        switch (action.toLowerCase()) {
            case "even":
                System.out.print("Even Numbers: ");
                for (int number : array) {
                    if (number % 2 == 0) {
                        System.out.print(number + " ");
                    }
                }
                System.out.println();
                break;
            case "odd":
                System.out.print("Odd Numbers: ");
                for (int number : array) {
                    if (number % 2 != 0) {
                        System.out.print(number + " ");
                    }
                }
                System.out.println();
                break;
            default:
                System.out.println("Invalid action. Use 'even' or 'odd'.");
        }
    }

    // This method finds the first 'n' prime numbers from the given array.
    // It loops through each number in the array, checking if it's prime.
    // If a prime number is found, it is added to the list.
    // Once 'n' prime numbers are collected, the loop stops early.
    // The method then returns the list of found prime numbers.
    public ArrayList<Integer> firstNPrimes(int[] numbers, int n) {
        ArrayList<Integer> primes = new ArrayList<>();
        for (int number : numbers) {
            if (isPrime(number)) {
                primes.add(number);
                if (primes.size() == n) {
                    break; // Stop once we've found 'n' primes
                }
            }
        }
        return primes;
    }

    // This method generates a sequence of Fibonacci numbers up to 'n' elements.
    // The Fibonacci sequence starts with 0 and 1, and each new number is the sum of the previous two.
    // If 'n' is 0 or negative, we return an empty list.
    // We initialize two variables, 'a' and 'b', to store the last two Fibonacci numbers.
    // The first two numbers are added to the list before the loop starts.
    // The loop continues generating the sequence until 'n' numbers have been added.
    // The final list of Fibonacci numbers is returned.
    public ArrayList<Integer> firstNFibonacci(int n) {
        ArrayList<Integer> fibonacciNumbers = new ArrayList<>();
        if (n <= 0) {
            return fibonacciNumbers;
        }
        int a = 0, b = 1;
        fibonacciNumbers.add(a);
        if (n == 1) {
            return fibonacciNumbers;
        }
        fibonacciNumbers.add(b);
        for (int i = 2; i < n; i++) {
            int next = a + b;
            fibonacciNumbers.add(next);
            a = b;
            b = next;
        }
        return fibonacciNumbers;
    }

    // The main method serves as an entry point to test the methods.
    // It initializes test arrays and calls the methods to demonstrate functionality.
    public static void main(String[] args) {
        System.out.println("Running Prime and Fibonacci Tests...");
        int[] numbers = {6, 29, 28, 33, 11, 100, 101, 43, 89};
        int[] newNumbers = {98, 57, 29, 22, 198, 746, 209, 57, 10, 6, 999, 77, 381, 88, 209, 780};
        PracPrimeDirective pd = new PracPrimeDirective();
        
        // Testing prime number detection
        System.out.println("Is 10 prime? " + pd.isPrime(10));
        System.out.println("Is 7 prime? " + pd.isPrime(7));
        System.out.println("Is 1 prime? " + pd.isPrime(1));
        System.out.println("Is 2 prime? " + pd.isPrime(2));
        
        // Testing filtering prime numbers
        System.out.println("Prime numbers: " + pd.onlyPrimes(numbers));
        
        // Testing even and odd number filtering
        pd.oddEven("even", newNumbers);
        pd.oddEven("odd", newNumbers);
        
        // Testing finding the first N prime numbers
        System.out.println("First prime number: " + pd.firstNPrimes(numbers, 1));
        System.out.println("First 3 prime numbers: " + pd.firstNPrimes(numbers, 3));
        
        // Testing Fibonacci sequence generation
        System.out.println("First 20 Fibonacci numbers: " + pd.firstNFibonacci(20));
    }
}

