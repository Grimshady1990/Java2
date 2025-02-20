import java.util.ArrayList;

class LmnhNoodle {

    protected double lengthInCm;
    protected double widthInCm;
    protected String shape;
    protected String ingredient;

    LmnhNoodle(double lenCen, double widCen, String shp, String ingr) {

        this.lengthInCm = lenCen;
        this.widthInCm = widCen;
        this.shape = shp;
        this.ingredient = ingr;

    }

    public String toString() {
        return "This will be overriden";
    }

    public String getCookPrep() {
        return "This will be overriden";
    }

    public String getInfo(String noodleName) {
        return "this is a " + noodleName + " noodle and is made from " + ingredient;
    }

    public static void main(String[] args) {
        ArrayList<LmnhNoodle> noodles = new ArrayList<>();
        noodles.add(new LmnhPho());
        noodles.add(new LmnhSpaghetti());
        noodles.add(new LmnhRamen());
        noodles.add(new LmnhUdon());
        for (LmnhNoodle noodle : noodles) {
            System.out.println(noodle.getCookPrep());
        }

        LmnhPho pho = new LmnhPho();
        System.out.println(pho);
        LmnhUdon udon = new LmnhUdon();
        System.out.println(udon);
        LmnhRamen ramen = new LmnhRamen();
        System.out.println(ramen);
        LmnhSpaghetti spag = new LmnhSpaghetti();
        System.out.println(spag);
        
        System.out.println(spag.getInfo("Spagghettioooos"));
        System.out.println(pho.getInfo("phew"));
        System.out.println(ramen.getInfo("ramen jammen"));
        System.out.println(udon.getInfo("udon on one"));


        
        
    }




}
