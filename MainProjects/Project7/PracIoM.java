
// Subclass that represents a language from the Isle of Man.
public class PracIoM extends PracLanguage {

    // Constructor that initializes the Manx language with default region and word order.
    public PracIoM(String languageName, int speakers) {
        // Calls the parent class constructor with predefined values.
        super(languageName, speakers, "Isle of Man", "Verb-Subject-Object");
    }

    // Overrides the getInfo() method to provide specific details about Manx.
    @Override
    public void getInfo() {
        System.out.println(this.name + " is spoken by " + this.numSpeakers + " people mainly in " + this.regionsSpoken + ".");
        System.out.println("The language follows the word order: " + this.wordOrder);
    }
}

