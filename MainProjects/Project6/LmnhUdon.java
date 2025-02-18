public class LmnhUdon extends LmnhNoodle {

    LmnhUdon() {
        super(1.39, 2.78, "hexagonal", "goosefat");
    }

    @Override
    public String toString() {
        return "Udon is " + lengthInCm + "cm long, " + widthInCm + "cm wide and is a odd " + shape + " and is made out of a special breed of " + ingredient + ".";
    }

    @Override
    public String getCookPrep() {
        return "put Udon in the oven with roast potatos and cook 20mins per lb";
    }
}
