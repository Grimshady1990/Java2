public class LmnhMayan extends LmnhLanguage {
    LmnhMayan(String langName, int speakers) {
        super(langName, speakers, "Central America", "Verb-Object-Subject");
    }

    @Override
    public void getInfo() {
        System.out.println("The " + this.name + " language is spoken by " + this.numSpeakers + " and is primarly spoken in " + this.regionsSpoken + " and has a word order of " + this.wordOrder);
    }
}
