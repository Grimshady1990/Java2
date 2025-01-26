import java.util.Arrays;
public class StringMethods {
  static String strMethods = "I am trying out string methods";
  static String strConcat = " and concatination!";
  static String eekWal = "I am equal to what?";
  static String eekWalRanCap = "i Am eqUal tO wHaT?";
  static String bigCaps = "MAKE ME LOWER CASE!";
  static String lowCase = "make me big caps!";
  public static void main(String[] args) {
    System.out.println(strMethods);
    // .length() prints the number of characters including " ".
    System.out.println(strMethods.length());
    // .concat() joins two strings together.
    System.out.println(strMethods.concat(strConcat));
    // .indexOf finds the index of a character in a string with the first index being zero (0).
    System.out.println(strMethods.indexOf("I"));
    // If we want the index of more than one character .indexOf() will only return the index at the start of the request.
    System.out.println(strMethods.indexOf("am trying"));
    // .charAt() Prints the character of the index you choose. works the opposite of indexOf
    System.out.println(strMethods.charAt(7));
    // .equals() checks if to strings are the same and is case sensitive
    System.out.println(eekWal.equals(eekWalRanCap));
    // .equalsIgnoreCase() is the same as .equals() but is not case sensitive.
    System.out.println(eekWal.equalsIgnoreCase(eekWalRanCap));
    // .substring() takes a index and starts the print from that index.
    System.out.println(strMethods.substring(5));
    // .toLowerCase prints in lowercase
    System.out.println(bigCaps.toLowerCase());
    // .toUpperCase prints in uppercase
    System.out.println(lowCase.toUpperCase());

  }
  
}
