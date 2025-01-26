import java.util.ArrayList;

class Noodle {
  
  protected double lengthInCentimeters;
  protected double widthInCentimeters;
  protected String shape;
  protected String ingredients;
  protected String texture = "brittle";
  
  Noodle(double lenInCent, double wthInCent, String shp, String ingr) {
    
    this.lengthInCentimeters = lenInCent;
    this.widthInCentimeters = wthInCent;
    this.shape = shp;
    this.ingredients = ingr;
    
  }

  public String getNoodleInfo(String noodleName) {
    return "This is a " + noodleName + " noodle made from " + ingredients + ".\n";
  }
  
  public String getCookPrep() {
    
    return "Boil noodle for 7 minutes and add sauce.";
    
  }
  
  public static void main(String[] args) {
    ArrayList<Noodle> noodles = new ArrayList<>();
    noodles.add(new Spaghetti());
    noodles.add(new Ramen());
    noodles.add(new Pho());
    noodles.add(new Udon());
    System.out.println("****COOKING INSTRUCTIONS*****\n");
    for (Noodle noodle : noodles){
      System.out.println(noodle.getCookPrep() + "\n");
    }
    System.out.println("*****SPECIFICATIONS*****\n");
    Ramen ramen = new Ramen();
    System.out.println(ramen);
    Spaghetti spaghetti = new Spaghetti();
    System.out.println(spaghetti);
    Udon udon = new Udon();
    System.out.println(udon);
    Pho pho = new Pho();
    System.out.println(pho);
    System.out.println("*****FLOUR TYPE*****\n");
    System.out.println(udon.getNoodleInfo("udon"));
    System.out.println(pho.getNoodleInfo("pho"));
    System.out.println(spaghetti.getNoodleInfo("spaghetti"));
    System.out.println(ramen.getNoodleInfo("ramen"));
    }
    
    
  }
  

