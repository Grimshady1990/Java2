public class LmnhRamen extends LmnhNoodle {

    LmnhRamen() {
        super(1.48, 9.34, "perculiar", "recycled toilet paper");
    }

    @Override
    public String toString() {
        return "Were Ramen!! at " + lengthInCm + "cm in length and " + widthInCm + " I hope yeah like a ramen too! with it's " + shape + " shape and a aroma of " + ingredient;
    }

    @Override
    public String getCookPrep() {
        return "Place ramen in a steeldrum and keep jammen until its cooked";
    }

}
