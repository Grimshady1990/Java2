public class PracLanguage {
    protected String name;
    protected int numSpeakers;
    protected String regionsSpoken;
    protected String wordOrder;

}
    
    public Language(String langName, int speakers, String regions, String wdOrder) {

        this.name = langName;
        this.numSpeakers = speakers;
        this.regionsSpoken = regions;
        this.wordOrder = wdOrder;
    }

    public void getInfo() {

        System.out.println(this.name + " is spoken by " + this.numSpeakers + " people mainly in " + this.regionsSpoken + ".\n The language follows the word order: " + this.wordOrder);
    }

    public static void displayLanguages() {
        Language[] languages = {
            new IoM("Manx", 100),
            new Mayan("Chontal", 60563),
            new SinoTibetan("Mandarin Chinese", 920000000);
            new SinoTibetan("Burmese", 33000000)
        };

        for (Language lang : languages) {
            lang.getInfo();
        }
    }  
