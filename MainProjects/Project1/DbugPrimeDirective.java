/* 
    🔥 Your Challenge:

    Find & fix at least 8 major bugs in the cursed code!

    Bug #1: The isPrime method is flawed—it mislabels prime numbers!
    Bug #2: onlyPrimes might not be filtering correctly—plus, it returns null!
    Bug #3: The even/odd filter is printing the wrong numbers!
    Bug #4: The Fibonacci sequence is broken—the logic is off!
    Bug #5: String comparison is incorrect in filterEvenOrOdd—it doesn't work!
    Bug #6: The isPrime method might miss some prime numbers!
    Bug #7: The loop in Fibonacci doesn't generate correct values!
    Bug #8: The output format is messy—fix it for clean results!
    
    💡 Hints:

    🧐 Remember that == doesn’t work for String comparison in Java!
    🤔 Think about how prime numbers are actually calculated.
    🚨 Null values can crash your program—fix them!
    ⚡ Test each method independently to isolate bugs.
*/

import java.util.ArrayList;

public class DbugPrimeDirective {

    // 🐛 Bug #1: Is this method even checking for primes correctly?
    public boolean isPrime(int number) {
        if (number <= 2) {  // 🤔 What about number == 2?
            return false;
        }
        for (int i = 2; i <= number / 2; i++) {  // 🤨 Is this the correct loop condition?
            if (number % i == 0) {
                return true;  // 🚨 Wait, what?!
            }
        }
        return false;  // 🤔 Double-check this return value!
    }

    // 🐛 Bug #2: Something is off with this method—it should return only prime numbers!
    public ArrayList<Integer> onlyPrimes(int[] numbers) {
        ArrayList<Integer> primes = new ArrayList<>();
        for (int number : numbers) {
            if (!isPrime(number)) {  // 🤔 Should this be reversed?
                primes.add(number);
            }
        }
        return null;  // 🚨 Wait, why is this returning null?!
    }

    // 🐛 Bug #3: This method is supposed to return even or odd numbers—but it's doing something weird!
    public void filterEvenOrOdd(String action, int[] numbers) {
        for (int number : numbers) {
            if (action == "even" && number % 2 == 1) {  // 🤔 Is this condition correct?
                System.out.println(number);
            } else if (action == "odd" && number % 2 == 0) {  // 🤨 What's happening here?!
                System.out.println(number);
            } else {
                System.out.println("Invalid action!");  // 🚨 This runs too often!
            }
        }
    }

    // 🐛 Bug #4: The Fibonacci sequence is broken!
    public ArrayList<Integer> firstNFibonacci(int n) {
        ArrayList<Integer> fibonacciNumbers = new ArrayList<>();
        if (n <= 0) {
            return fibonacciNumbers;
        }
        int a = 0, b = 1;
        fibonacciNumbers.add(a);
        fibonacciNumbers.add(b);
        for (int i = 2; i < n; i++) {
            int next = a + b;
            fibonacciNumbers.add(a);  // 🤨 Are we adding the correct number?
            a = b;
            b = next;
        }
        return fibonacciNumbers;
    }

    public static void main(String[] args) {
        DbugPrimeDirective dpd = new DbugPrimeDirective();

        // 🔍 Test Case 1: Prime Checking
        System.out.println("Is 2 Prime? " + dpd.isPrime(2));  // Expected: true
        System.out.println("Is 5 Prime? " + dpd.isPrime(5));  // Expected: true
        System.out.println("Is 10 Prime? " + dpd.isPrime(10)); // Expected: false

        // 🔍 Test Case 2: Extracting Prime Numbers
        int[] numbers = {6, 29, 15, 33, 11, 100, 101};
        System.out.println("Prime Numbers: " + dpd.onlyPrimes(numbers));  
        // Expected: [29, 11, 101]

        // 🔍 Test Case 3: Filtering Even/Odd Numbers
        System.out.println("Even Numbers:");
        dpd.filterEvenOrOdd("even", numbers);  // Expected: [6, 100]
        
        System.out.println("Odd Numbers:");
        dpd.filterEvenOrOdd("odd", numbers);  // Expected: [29, 15, 33, 11, 101]

        // 🔍 Test Case 4: Fibonacci Sequence
        System.out.println("First 5 Fibonacci Numbers: " + dpd.firstNFibonacci(5));
        // Expected: [0, 1, 1, 2, 3]
    }
}
