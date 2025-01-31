public class IoM extends Language{
  public IoM(String languageName, int speakers){
    super(languageName, speakers, "Foxdale", "Subject, Verb, Object");
}
@Override
  public void getInfo() {

    System.out.println(this.name + " is spoken by " + this.numSpeakers + " people mainly in " + this.regionsSpoken + ".");
    System.out.println("The language follows the word order: " + this.wordOrder);
    System.out.println("Fun Fact: " + this.name + " language was officially declared extinct by UNESCO in 2009—only for native speakers on the Isle of Man to protest and prove them wrong!");
  }
}
