public class LmnhPho extends LmnhNoodle {
    LmnhPho() {
        super(0.02, 2.56, "square", "plastic bags");
    }

    @Override
    public String toString() {
        return "Pho noodles: " + lengthInCentimeters + widthInCentimeters + shape + ingredients;
    }
    
    @Override
    public String getCookingPrep() {
        return "Boil noodles for 25 years and dont forget to shave";
    }
}
