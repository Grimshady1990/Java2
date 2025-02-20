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

    public static void loopLang() {
        LmnhLanguage[] languages = {
        new LmnhMayan("Chondal", 32432423),
        new LmnhSinoTibetan("Chinese Mandarin", 9999999),
        new LmnhSinoTibetan("Burmese", 34783743),
        new LmnhIoM("Manx", 1000)

    };
        for (LmnhLanguage lang : languages) {
            lang.getInfo();
        }
    }

    public void setRegion(String reg) {
        this.regionsSpoken = reg;
    }

    public void setSpeakers(int spek) {
        this.numSpeakers = spek;
    }

    public void setWdOrder(String order) {
        this.wordOrder = order;
    }

    
    public static void main(String[] args) {
        LmnhIoM manx = new LmnhIoM("Manx", 1000); 
        manx.getInfo(); 

        LmnhMayan chondal = new LmnhMayan("Chondal", 999999);
        chondal.getInfo();

        LmnhSinoTibetan mandarin = new LmnhSinoTibetan("Chinese Mandarin", 10000000);
        mandarin.getInfo();

        LmnhSinoTibetan burmese = new LmnhSinoTibetan("Burmese", 487384);
        burmese.getInfo();

        loopLang();

        manx.setRegion("Isle of Man");
        manx.setSpeakers(999999999);
        manx.setWdOrder("@@@@@@@");
        manx.getInfo();
    }
}
