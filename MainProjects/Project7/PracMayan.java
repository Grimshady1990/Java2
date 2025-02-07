
// Subclass representing Mayan languages.
public class PracMayan extends PracLanguage {

    // Constructor that initializes a Mayan language with default region and word order.
    public PracMayan(String languageName, int speakers) {
        // Calls the parent class constructor with predefined values.
        super(languageName, speakers, "Central America", "Verb-Object-Subject");
    }

    // Overrides the getInfo() method to provide specific details about Mayan languages.
    @Override
    public void getInfo() {
        System.out.println(this.name + " is spoken by " + this.numSpeakers + " people mainly in " + this.regionsSpoken + ".");
        System.out.println("The language follows the word order: " + this.wordOrder);
        System.out.println("Fun fact: Mayan languages are known for their use of glottalized consonants!");
    }
}

