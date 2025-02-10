
// 🚀 Welcome to your interactive Java coding practice! Follow the guided steps below to write your code from scratch.

import java.util.ArrayList;

// 🎯 Step 1: Define a public class
// Every Java program starts with a class definition. Give your class an appropriate name.
// 💡 Hint: Use PascalCase for class names.
// 💡 Hint: Place the closing curly bracket of your public class at the bottom of the page.
// 💡 Hint: Public class names must match the file name.
// ✍️ Type your code below this comment

public class FinTempPrimeDirective {


// 🎯 Step 2: Create a method to check if a number is prime
// This method should:
// ✅ Take an integer as input and return a boolean
// ✅ Return false if the number is less than 2
// ✅ Loop from 2 to the given number (excluding the number itself)
// ✅ Return false if the number is divisible by any of these
// ✅ Otherwise, return true
// 💡 Hint: Prime numbers are only divisible by 1 and themselves.
// ✍️ Type your code below this comment

    public boolean isPrime(int n) {
       
        if (n < 2) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        
        for (int i = 2; n > i; i++){
            if (n % i == 0) {
                return false;
        }
        }
     
        return true;
        
    }
    

// 🎯 Step 3: Create a method to extract prime numbers from an array
// This method should:
// ✅ Take an array of integers as input
// ✅ Initialize an empty list to store prime numbers
// ✅ Loop through each number in the given array
// ✅ Check if the number is prime using the previously defined method
// ✅ If prime, add it to the list
// ✅ Return the list of prime numbers
// 💡 Hint: Use an enhanced for-loop to iterate through the array.
// ✍️ Type your code below this comment

    public ArrayList<Integer> onlyPrimes(int[] array) {
        ArrayList<Integer> primes = new ArrayList<>();
        for (int number : array) { 
            if (isPrime(number)) {  
            
                primes.add(number);
            }
        }
        return primes;    
        
    }
    

// 🎯 Step 4: Create a method to filter even or odd numbers from an array
// This method should:
// ✅ Take an action ("even" or "odd") and an array of numbers
// ✅ Print all even numbers if the action is "even"
// ✅ Print all odd numbers if the action is "odd"
// ✅ Print an error message if the action is not recognized
// 💡 Hint: Use the modulus operator (%) to check divisibility.
// ✍️ Type your code below this comment

    public void oddEven(String action, int[] array) {
        ArrayList<Integer> primes = new ArrayList<>();
        switch(action.toLowerCase()) {
            case "even":
                for (int number : array) {
                    if (number % 2 == 0) {
                        primes.add(number);
                                            }
                }
                System.out.println("Even Numbers: " + primes); 

                break;
            case "odd":
                for (int number : array) {
                    if (number % 2 != 0) {
                        primes.add(number);
                                            }
                }
                System.out.println("Odd Numbers: " + primes);

                break;
            default:
                System.out.println("Invalid Action!");
                break;
        }
        
    }

// 🎯 Step 5: Create a method to find the first N prime numbers from an array
// This method should:
// ✅ Take an array of integers and an integer N
// ✅ Initialize an empty list to store prime numbers
// ✅ Loop through the array, checking if each number is prime
// ✅ Add prime numbers to the list until N primes are found
// ✅ Return the list of the first N prime numbers
// 💡 Hint: Break the loop when the list reaches N elements.
// ✍️ Type your code below this comment

    public ArrayList<Integer> firstNPrimes(int[] array, int n) {
        ArrayList<Integer> primes = new ArrayList<>();
        int i = 0;
        for (int number : array) {
            if (isPrime(number)) {
                primes.add(number);
                i++;
                if (i == n) {
                    break;
                }
            }

        }
        return primes;
    }

// 🎯 Step 6: Create a method to generate the Fibonacci sequence up to N elements
// This method should:
// ✅ Take an integer N as input
// ✅ Return an empty list if N is 0 or negative
// ✅ Initialize two integers representing the first two numbers in the sequence
// ✅ Add the first number to the list
// ✅ If N > 1, add the second number as well
// ✅ Use a loop to generate the next numbers by summing the last two
// ✅ Return the list of Fibonacci numbers
// 💡 Hint: Use a loop to calculate each new number in the sequence.
// ✍️ Type your code below this comment

    public ArrayList<Integer> firstNFibonacci(int n) {
        ArrayList<Integer> fibArray = new ArrayList<>();
        if (n <= 0) {
            return fibArray;

        }
        int a = 0, b = 1;
        if (n >= 1) {
            fibArray.add(a);
        }
        if (n >= 2) {
            fibArray.add(b);
        }
        int next = 2;
        for (int i = 2; i < n; i++) {
            next = a + b;
            a = b;
            b = next;
            fibArray.add(next); 
        }
        return fibArray;
    }

// 🎯 Step 7: Create a main method to test all methods
// ✅ Initialize test arrays with numbers
// ✅ Create an instance of your class
// ✅ Call and print the results of the prime-checking method
// ✅ Call and print the results of the prime-filtering method
// ✅ Call the even/odd filtering method to display results
// ✅ Call and print the results of the first N prime numbers method
// ✅ Call and print the results of the Fibonacci sequence method
// 💡 Hint: Use System.out.println() to display results.
// ✍️ Type your code below this comment

    public static void main(String[] args){
        int[] numbers = {6, 29, 28, 33, 11, 100, 101, 43, 89};
    
        FinTempPrimeDirective pd = new FinTempPrimeDirective();
        System.out.println(pd.isPrime(7));
        System.out.println(pd.isPrime(5));
        System.out.println(pd.isPrime(4));
        System.out.println(pd.isPrime(2));
        System.out.println(pd.isPrime(1));
        System.out.println(pd.isPrime(8));
        System.out.println(pd.onlyPrimes(numbers));
        pd.oddEven("even", numbers); 
        pd.oddEven("odd", numbers);
        System.out.println(pd.firstNPrimes(numbers, 4));
        System.out.println(pd.firstNFibonacci(0));
        System.out.println(pd.firstNFibonacci(1));
        System.out.println(pd.firstNFibonacci(2));
        System.out.println(pd.firstNFibonacci(3));
        System.out.println(pd.firstNFibonacci(4));
        System.out.println(pd.firstNFibonacci(5));
        System.out.println(pd.firstNFibonacci(6));
        System.out.println(pd.firstNFibonacci(7));
        System.out.println(pd.firstNFibonacci(20));


    }
// 🎉 Great job! Run your code and check if everything works as expected. Debug if needed!

}
   
