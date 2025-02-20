public class LmnhSpaghetti extends LmnhNoodle {

    LmnhSpaghetti() {
        super(1.84, 0.39, "star", "potato peelings");
    }

    @Override
    public String toString() {
        return "Spaggy Spaggy Spagghettioooos " + lengthInCm + "cm in length and " + widthInCm + "cm wide. It shines bright like a " + shape + " and is made from merris piper " + ingredient + ".";
    }

    @Override
    public String getCookPrep() {
        return "soak Spagghettioooos in milk till they are soft";
    }


} 
