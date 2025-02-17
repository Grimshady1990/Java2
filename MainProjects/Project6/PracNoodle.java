
import java.util.ArrayList;

class PracNoodle {

    // Protected variables can be accessed by subclasses due to inheritance.
    protected double lengthInCentimeters;
    protected double widthInCentimeters;
    protected String shape;
    protected String ingredients;
    
    // Constructor initializes the noodle properties using parameters.
    PracNoodle(double lenInCent, double wthInCent, String shp, String ingr) {
        // Assigns the constructor parameters to the object's fields.
        this.lengthInCentimeters = lenInCent;
        this.widthInCentimeters = wthInCent;
        this.shape = shp;
        this.ingredients = ingr;
    }

    // This method returns a string describing the noodle type and its ingredients.
    public String getNoodleInfo(String noodleName) {
        return "This is a " + noodleName + " noodle made from " + ingredients + ".\n";
    }

    // This method provides a basic cooking preparation instruction for noodles.
    // Although this is not used directly, it's necessary for subclasses to override it.
    public String getCookPrep() {
        return "Boil noodle for 7 minutes and add sauce.";
    }



    // This method provides a default string representation for all PracNoodle objects.
    // It is intended to be overridden by subclasses to provide more specific details 
    // about each type of noodle while ensuring consistent behavior when printed.
    public String toString() {
    return "This is a PracNoodle.";
}


    public static void main(String[] args) {
        // Create a new ArrayList to store different noodle types.
        ArrayList<PracNoodle> noodles = new ArrayList<>();

        // Add instances of different noodle types (subclasses) to the list.
        noodles.add(new PracSpaghetti());
        noodles.add(new PracRamen());
        noodles.add(new PracPho());
        noodles.add(new PracUdon());

        // Print a header for the cooking instructions section.
        System.out.println("****COOKING INSTRUCTIONS****\n");

        // Loop through the ArrayList and print cooking instructions for each noodle type.
        for (PracNoodle noodle : noodles) {
            System.out.println(noodle.getCookPrep() + "\n");
        }

        // Print a header for the noodle specifications section.
        System.out.println("****SPECIFICATIONS****\n");

        // Create an instance of PracRamen to demonstrate overridden methods.
        PracRamen ramen = new PracRamen();
        System.out.println(ramen);  // Prints the overridden toString() method.

        // Repeat the process for other noodle types.
        PracSpaghetti spaghetti = new PracSpaghetti();
        System.out.println(spaghetti);  // Prints the overridden toString() method.
        PracUdon udon = new PracUdon();
        System.out.println(udon);  // Prints the overridden toString() method.
        PracPho pho = new PracPho();
        System.out.println(pho);  // Prints the overridden toString() method.

        // Print a header for the flour type section.
        System.out.println("****FLOUR TYPE****\n");

        // Prints out the specific noodle information (name and ingredients) for each type.
        System.out.println(udon.getNoodleInfo("udon"));
        System.out.println(pho.getNoodleInfo("pho"));
        System.out.println(spaghetti.getNoodleInfo("spaghetti"));
        System.out.println(ramen.getNoodleInfo("ramen"));
    }

}

