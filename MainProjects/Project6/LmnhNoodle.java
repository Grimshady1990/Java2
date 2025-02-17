import java.util.ArrayList;

class LmnhNoodle {

    protected double lengthInCentimeters;
    protected double widthInCentimeters;
    protected String shape;
    protected String ingredients;

    LmnhNoodle(double lenInCent, double wthInCent, String shp, String ingr) {

        this.lengthInCentimeters = lenInCent;
        this.widthInCentimeters = wthInCent;
        this.shape = shp;
        this.ingredients = ingr;
    }

    public String toString() {
        return "does not matter as this method will be overridden.";
    }

    public String getNoodleInfo(String noodleName) {
        return "This one is not being overridden so shut up and eat your " + noodleName + " noodles which are a full of " + ingredients + ".";
    } 

    public String getCookPrep() {
        return "This one dont matter will be overridden.";
    }


    public static void main(String[] args) {

         ArrayList<LmnhNoodle> noodles = new ArrayList<>();
         noodles.add(new LmnhPho());
         noodles.add(new LmnhUdon());
         noodles.add(new LmnhRamen());
         noodles.add(new LmnhSpaghetti());

         for (LmnhNoodle noodle : noodles) {
             System.out.println(noodle.getCookPrep());
         }

         LmnhUdon udon = new LmnhUdon();
         System.out.println(udon);
         LmnhRamen ramen = new LmnhRamen();
         System.out.println(ramen);
         LmnhPho pho = new LmnhPho();
         System.out.println(pho);
         LmnhSpaghetti spaghetti = new LmnhSpaghetti();
         System.out.println(spaghetti);

         System.out.println(udon.getNoodleInfo("udon"));
         System.out.println(spaghetti.getNoodleInfo("spaggy"));
         System.out.println(ramen.getNoodleInfo("ramit"));
         System.out.println(pho.getNoodleInfo("poo"));


    }

}
