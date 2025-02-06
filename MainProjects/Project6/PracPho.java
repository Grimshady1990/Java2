
// This subclass uses extends to inherit the protected attributes from the PracNoodle class.
class PracPho extends PracNoodle {

    // Constructor for PracPho, calls the parent constructor using super to initialize inherited variables.
    PracPho() {
        // super() is used to call the parent constructor and pass values for the protected attributes.
        super(30.0, 0.64, "flat", "rice flour");
    }

    // The toString() method is overridden to provide a custom string representation of the Pho noodle object.
    @Override
    public String toString() {
        return "Pho: Length = " + lengthInCentimeters + "cm, Width = " + widthInCentimeters + "cm, Shape = " + shape + ", Ingredients = " + ingredients + "\n";
    }

    // The getCookPrep() method is overridden to provide specific cooking instructions for Pho.
    @Override
    public String getCookPrep() {
        return "Pho: Soak pho for 1 hour, then boil for 1 minute in broth. Then garnish with cilantro and jalapeno.";
    }
}

