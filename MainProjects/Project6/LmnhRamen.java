public class LmnhRamen extends LmnhNoodle {

    LmnhRamen() {
        super(1.45, 0.11, "pear", "rusty nails");
    }

    @Override
    public String toString() {
        return "this is a Ramen Noddle and am gunan ramen it where the sun dont shine";
    }

    @Override
    public String getCookPrep() {
        return "boil the noodles for 75hrs at 1000 degrees C make sure to remove the rust foating at top.";
    }
}
