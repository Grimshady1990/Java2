// Import statement:
import java.util.ArrayList;
class PrimeDirective {
  
  // Add your methods here:
  public boolean isPrime(int number){
    if (number == 2){
      return true;
    }
    else if (number < 2){
      return false;
    }
    for (int i = 2; i < number; i++){
      if (number % i == 0){
        return false;
    }
    }
    return true;
  }
  
  public ArrayList<Integer> onlyPrimes(int[] numbers){
    ArrayList<Integer> primes = new ArrayList<Integer>();
    for (int number : numbers){
      if (isPrime(number)) {
        primes.add(number);
      }
      
    }
    return primes;
  }

  public void printNumbers(String action, int[] array){
    switch(action.toLowerCase()){
      case "even":
        System.out.print("Even Numbers: ");
        for (int number : array){
          if (number % 2 == 0){
            System.out.print(number + " ");
          }
        }
        System.out.println();
        break;
      case "odd":
        System.out.print("Odd Numbers; ");
        for (int number : array) {
          if (number % 2 != 0){
            System.out.print(number + " ");
          }
        }
        System.out.println();
        break;
        default:
          System.out.println("Invalid action");
    }
  }
  public ArrayList<Integer> firstNPrimes(int[] numbers, int n) {
    ArrayList<Integer> primes = new ArrayList<Integer>();
    for (int number : numbers) {
      if (isPrime(number)) {
        primes.add(number);
        if(primes.size() == n) {
          break;
        }
      }
    }
    return primes;
  }
  public ArrayList<Integer> firstNFibonacci(int n) {
    ArrayList<Integer> fibonacciNumbers = new ArrayList<Integer>();
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
  public static void main(String[] args) {

    PrimeDirective pd = new PrimeDirective();
    int[] numbers = {6, 29, 28, 33, 11, 100, 101, 43, 89};
    System.out.println(pd.isPrime(7));
    System.out.println(pd.isPrime(28));
    System.out.println(pd.isPrime(2));
    System.out.println(pd.isPrime(0));
    System.out.println(pd.onlyPrimes(numbers));
    pd.printNumbers("even", numbers);
    pd.printNumbers("odd", numbers);
    ArrayList<Integer> primes = pd.firstNPrimes(numbers, 1);
    System.out.println(primes);
    ArrayList<Integer> fibonacci = pd.firstNFibonacci(20);
    System.out.println(fibonacci);
  }  
  }
  


