import java.util.Arrays;

public class PracStringMethods {

    // These are different string variables that serve to perform certain actions.
    // The clue to what they are used for is in each variable name.
    static String strMethods = "I am trying out string methods";
    static String strConcat = " and concatination!";
    static String eekWal = "I am equal to what?";
    static String eekWalRanCaps = "i Am eQUal To wHat?";
    static String allCaps = "MAKE ME LOWER CASE!";
    static String lowCase = "make me all caps!";

    public static void main(String[] args) {


        // Prints a regular string.
        System.out.println(strMethods);

        // Prints the length of strMethods as an integer.
        System.out.println(strMethods.length());

        // Concatenates strMethods with strConcat.
        System.out.println(strMethods.concat(strConcat));

        // Prints the index of a chosen character or substring as an integer.
        System.out.println(strMethods.indexOf("I"));

        // Prints the index of the first occurrence of the chosen substring.
        System.out.println(strMethods.indexOf("am trying"));

        // Prints the character at the specified index. Works as an inverted indexOf.
        System.out.println(strMethods.charAt(7));

        // Checks if eekWal is equal to eekWalRanCaps (case-sensitive).
        System.out.println(eekWal.equals(eekWalRanCaps));

        // Checks if eekWal is equal to eekWalRanCaps (case-insensitive).
        System.out.println(eekWal.equalsIgnoreCase(eekWalRanCaps));

        // Extracts and prints a substring starting from the specified index.
        System.out.println(strMethods.substring(5));

        // Converts and prints the string in lowercase.
        System.out.println(allCaps.toLowerCase());

        // Converts and prints the string in uppercase.
        System.out.println(lowCase.toUpperCase());
    }

}


