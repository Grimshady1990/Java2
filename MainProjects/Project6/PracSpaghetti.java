
// The PracSpaghetti class extends PracNoodle, inheriting its protected attributes.
class PracSpaghetti extends PracNoodle {

    // Constructor for PracSpaghetti, calls the parent constructor with specific values for spaghetti.
    PracSpaghetti() {
        super(30.0, 0.2, "round", "semolina flour");
    }

    // The toString() method provides a custom string representation of the Spaghetti noodle object.
    @Override
    public String toString() {
        return "Spaghetti: Length = " + lengthInCentimeters + "cm, Width = " + widthInCentimeters + "cm, Shape = " + shape + ", Ingredients = " + ingredients + "\n";
    }

    // This method provides specific cooking instructions for Spaghetti.
    @Override
    public String getCookPrep() {
        return "Spaghetti: Boil spaghetti for 8 - 12 minutes and add sauce, cheese, or oil and garlic.";
    }
}

