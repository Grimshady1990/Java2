public class LmnhPho extends LmnhNoodle {

    LmnhPho() {
        super(0.32, 0.55, "oblong", "rusty nails");
    }

    @Override
    public String toString() {
        return "Pho Pho Pow " + lengthInCm + "cm long and " + widthInCm + "cm wide this " + shape + " shaped noodle has a bite so watch out for " + ingredient + ".";
    }

    @Override
    public String getCookPrep() {
        return "Whack it in the oven and leave it in till you have completed your rubics cube";
    }


}
