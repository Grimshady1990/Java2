
// Subclass that inherits from PracLanguage using 'extends'.
public class PracSinoTibetan extends PracLanguage {

    // Constructor with two parameters that can be customized in the main method.
    public PracSinoTibetan(String languageName, int speakers) {

        // Calls the parent class constructor using 'super' to set default values.
        super(languageName, speakers, "Asia", "Subject-Object-Verb");

        // If the language name contains "Chinese," update the word order.
        if (languageName.contains("Chinese")) {
            this.wordOrder = "Subject-Verb-Object";
        }
    }

    // Overrides the getInfo() method from the parent class to provide specific details.
    @Override
    public void getInfo() {
        System.out.println(this.name + " is spoken by " + this.numSpeakers + " people mainly in " + this.regionsSpoken + ".");
        System.out.println("The language follows the word order: " + this.wordOrder);
    }
}

