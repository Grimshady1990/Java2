// We need to showcase different string methods
// we need to join two strings
// make a string AllCaps
// make a string lower case
// decide if a string is equal to another
// can it be equal and ignore caps
// find the index of a given character.
// find a charcter at a given index
// create a sub string

public class LmnhStrMeth {

    static String baseString = "I am a silly string";
    static String concatMe = ", but only on Saturdays.";
    static String eekWal = "What am I equal too?";
    static String ranEekWal = "wHAt aM i eqUaL tOo?";
    static String allCaps = "make me allcaps!";
    static String lowCase = "MAKE ME LOWER CASE";


    public static void main(String[] args) {
        System.out.println(baseString);
        System.out.println(baseString.concat(concatMe));
        System.out.println(eekWal.equals(ranEekWal));
        System.out.println(eekWal.equalsIgnoreCase(ranEekWal));
        System.out.println(allCaps.toUpperCase());
        System.out.println(lowCase.toLowerCase());
        System.out.println(baseString.indexOf("I"));
        System.out.println(baseString.charAt(0));
        System.out.println(baseString.substring(7));
    }
}
