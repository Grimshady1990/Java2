public class LmnhLanguage {
    protected int numSpeakers;
    protected String regionsSpoken;
    protected String name;
    protected String wordOrder;

    public LmnhLanguage(String langName, int speakers, String regions, String wdOrder) {

        this.name = langName;
        this.regionsSpoken = regions;
        this.numSpeakers = speakers;
        this.wordOrder = wdOrder;
    }
    
    public void getInfo() {
        System.out.println("This will be overridden");
        
    }

    public void loopLang() {

    }
}
