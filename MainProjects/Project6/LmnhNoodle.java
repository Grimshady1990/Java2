import java.util.ArrayList;

import javax.swing.SortOrder;

class LmnhNoodle {
    protected double lengthInCentimeters;
    protected double widthInCentimeters;
    protected String shape;
    protected String ingredients;

    LmnhNoodle(double lenInCen, double widInCen, String shp, String ingr) {
        this.lengthInCentimeters = lenInCen;
        this.widthInCentimeters = widInCen;
        this.shape = shp;
        this.ingredients = ingr;
    }

    public String toString() {
        return "Does matter this will be overriden";
    }

    public String getCookingPrep() {
        return "will also be overriden";
    }
    public  String getNoodleInfo(String nameNoodle) {
        return "This is a " + nameNoodle + " and is made of " + ingredients + ".";
    }

    public static void main(String[] args) {
        ArrayList<LmnhNoodle> noodles = new ArrayList<>();
        noodles.add(new LmnhUdon());
        noodles.add(new LmnhPho());
        noodles.add(new LmnhRamen());
        noodles.add(new LmnhSpaghetti());


        for (LmnhNoodle noodle : noodles) {
            System.out.println(noodle.getCookingPrep());

        }

        LmnhRamen ramen = new LmnhRamen();
        LmnhSpaghetti spag = new LmnhSpaghetti();
        LmnhUdon udon = new LmnhUdon();
        LmnhPho pho = new LmnhPho();
        System.out.println(udon);
        System.out.println(spag);
        System.out.println(pho);
        System.out.println(ramen);

        System.out.println(spag.getNoodleInfo("spaggy"));
        System.out.println(udon.getNoodleInfo("udon"));
        System.out.println(ramen.getNoodleInfo("ramen"));
        System.out.println(pho.getNoodleInfo("pho"));
        
    }
}
