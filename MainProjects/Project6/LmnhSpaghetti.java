public class LmnhSpaghetti extends LmnhNoodle {

    LmnhSpaghetti(){
        super(0.50, 1.49, "penis", "sea salt");
    }

    @Override
    public String toString() {
        return "Spaghetti: " + lengthInCentimeters + widthInCentimeters + shape + ingredients;
    }

    @Override
    public String getCookingPrep() {
        return "cooking Spaggy takes a specail kind of man give up";
    }
   

}

