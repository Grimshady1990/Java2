
public class PracLanguage {

    // These variables are protected, meaning they can only be accessed by subclasses through inheritance.
    protected String name;
    protected int numSpeakers;
    protected String regionsSpoken;
    protected String wordOrder;

    // Constructor that initializes the language name, number of speakers, regions spoken, and word order.
    public PracLanguage(String langName, int speakers, String regions, String wdOrder) {
        this.name = langName;
        this.numSpeakers = speakers;
        this.regionsSpoken = regions;
        this.wordOrder = wdOrder;
    }

    // Method to display information about the language.
    // If overridden in a subclass, it will display the subclass-specific details.
    public void getInfo() {
        System.out.println(this.name + " is spoken by " + this.numSpeakers + " people mainly in " + this.regionsSpoken + ".\nThe language follows the word order: " + this.wordOrder);
    }

    // This method creates an array of language objects and uses a for-each loop to display their details.
    public static void displayPracLanguages() {
        PracLanguage[] languages = {
            new PracIoM("Manx", 100),
            new PracMayan("Chontal", 60563),
            new PracSinoTibetan("Mandarin Chinese", 920000000),
            new PracSinoTibetan("Burmese", 33000000)
        };
        for (PracLanguage lang : languages) {
            lang.getInfo();
        }
    }

    // Setter methods to modify language attributes after object creation.
    public void setRegionsSpoken(String regions) {
        this.regionsSpoken = regions;
    }

    public void setNumSpeakers(int speakers) {
        this.numSpeakers = speakers;
    }

    public void setWordOrder(String order) {
        this.wordOrder = order;
    }

    public static void main(String[] args) {

        // Creating an instance of PracIoM and displaying its details.
        PracIoM manx = new PracIoM("Manx", 100);
        System.out.println("**** ISLE OF MAN | MANX ****");
        manx.getInfo();
        System.out.println();

        // Creating an instance of PracMayan and displaying its details.
        PracMayan chontal = new PracMayan("Chontal", 60563);
        System.out.println("**** MAYAN | CHONTAL ****");
        chontal.getInfo();
        System.out.println();

        // Creating an instance of PracSinoTibetan (Mandarin Chinese) and displaying its details.
        PracSinoTibetan mandarin = new PracSinoTibetan("Mandarin Chinese", 920000000);
        System.out.println("**** SINO-TIBETAN | MANDARIN CHINESE ****");
        mandarin.getInfo();
        System.out.println();

        // Creating an instance of PracSinoTibetan (Burmese) and displaying its details.
        PracSinoTibetan burmese = new PracSinoTibetan("Burmese", 33000000);
        System.out.println("**** SINO-TIBETAN | BURMESE ****");
        burmese.getInfo();
        System.out.println();

        // Displaying all language objects stored in the array.
        System.out.println("***** LOOP ARRAY *****");
        displayPracLanguages();
        System.out.println();

        // Demonstrating the use of setter methods.
        System.out.println("***** SETTERS *****");
        manx.setRegionsSpoken("Isle of Man");
        manx.setNumSpeakers(500);
        manx.setWordOrder("Object-Verb-Subject");

        // Displaying the updated information for the Manx language.
        manx.getInfo();
    }
}

