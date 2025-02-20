public class LmnhIoM extends LmnhLanguage {
   LmnhIoM(String langName, int speakers){
        super(langName, speakers, "FoxDale", "Subject-Verb-Object");
    }
    
   @Override
   public void getInfo() {
       System.out.println("The " + this.name + " language is spoken by " + this.numSpeakers + " and is primarly spoken in a place called " + this.regionsSpoken + " with a word order of " + this.wordOrder + ".");
   }
}
