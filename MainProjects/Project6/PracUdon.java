
// The PracUdon class extends PracNoodle, inheriting its protected attributes.
class PracUdon extends PracNoodle {

    // Constructor for PracUdon, calls the parent constructor with specific values for Udon.
    PracUdon() {
        super(50.0, 0.99, "round", "wheat flour");
    }

    // The toString() method provides a custom string representation of the Udon noodle object.
    @Override
    public String toString() {
        return "Udon: Length = " + lengthInCentimeters + "cm, Width = " + widthInCentimeters + "cm, Shape = " + shape + ", Ingredients = " + ingredients + "\n";
    }

    // This method provides specific cooking instructions for Udon.
    @Override
    public String getCookPrep() {
        return "Udon: The dough is kneaded, rested, and then rolled out and cut into thick strips. The noodles are then boiled until tender.";
    }
}

