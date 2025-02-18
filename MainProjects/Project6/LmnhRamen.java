public class LmnhRamen extends LmnhNoodle {
    LmnhRamen() {
        super(0.32, 1.34, "round", "rusty nails");
    }

    @Override
    public String toString() {
        return "Ramen Noodle " + lengthInCentimeters + widthInCentimeters + shape + ingredients;
    }

    @Override
    public String getCookingPrep() {
        return "Ram the ramin where the sun dont shine.";
    }
}
