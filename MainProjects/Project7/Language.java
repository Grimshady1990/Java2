public class Language{
  protected String name;
  protected int numSpeakers;
  protected String regionsSpoken;
  protected String wordOrder;

  public Language(String langName, int speakers, String regions, String wdOrder) {
      this.name = langName;
      this.numSpeakers = speakers;
      this.regionsSpoken = regions;
      this.wordOrder = wdOrder;
  }

  public void getInfo(){
    System.out.println(this.name + " is spoken by " + this.numSpeakers + " people mainly in " + this.regionsSpoken + ".\n The language follows the word order: " + this.wordOrder);
  }
  public static void displayLanguages(){
        Language[] languages = {
        new IoM("Manx", 100),
        new Mayan("Chontal", 60563),
        new SinoTibetan("Mandarin Chinese", 920000000),
        new SinoTibetan("Burmese", 33000000)
    };

    for (Language lang : languages) {
        lang.getInfo();
    }
  }
  // Setter for regionsSpoken
  public void setRegionsSpoken(String regions){
    this.regionsSpoken = regions;
  }
  // setter for numSpeakers
  public void setNumSpeakers(int speakers){
    this.numSpeakers = speakers;
  }
  // setter for wordOrder
  public void setWordOrder(String order){
    this.wordOrder = order;
  }
  public static void main(String[] args){
    IoM manx = new IoM("Manx", 100);
    manx.getInfo();
    Mayan chontal = new Mayan("Chontal", 60563);
    chontal.getInfo();
    SinoTibetan mandarin = new SinoTibetan("Mandarin Chinese", 920000000);
    mandarin.getInfo();
    SinoTibetan burmese = new SinoTibetan("Burmese", 33000000);
    burmese.getInfo();
    System.out.println("*****LOOP ARRAY*****");
    displayLanguages();
    System.out.println("*****SETTERS*****");
    manx.setRegionsSpoken("Isle of Man");
    manx.setNumSpeakers(500);
    manx.setWordOrder("subject-verb-object");
    manx.getInfo();
  }
  
  
}
