
// The PracRamen class extends PracNoodle, inheriting its protected attributes.
class PracRamen extends PracNoodle {

    // Constructor for PracRamen, calls the parent constructor with specific values for ramen.
    PracRamen() {
        super(30.0, 0.3, "flat", "wheat flour");
    }

    // The toString() method provides a custom string representation of the Ramen noodle object.
    @Override
    public String toString() {
        return "Ramen: Length = " + lengthInCentimeters + "cm, Width = " + widthInCentimeters + "cm, Shape = " + shape + ", Ingredients = " + ingredients + "\n";
    }

    // This method provides specific cooking instructions for Ramen.
    @Override
    public String getCookPrep() {
        return "Ramen: Boil ramen for 5 minutes in broth, then add meat, mushrooms, egg, and vegetables.";
    }
}

