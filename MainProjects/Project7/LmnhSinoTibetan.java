public class LmnhSinoTibetan extends LmnhLanguage {
    LmnhSinoTibetan(String langName, int speakers) {
        super(langName, speakers, "Asia", "Object-Verb-Subject");

        if (name.contains("Chinese")) {
            this.wordOrder = "Subject-Verb-Object";
        }
    }

    @Override
    public void getInfo() {
        System.out.println("The " + this.name + " language is spoken by " + this.numSpeakers + " and is mainly used in " + this.regionsSpoken + " and the word order is " + this.wordOrder);
    }

}
