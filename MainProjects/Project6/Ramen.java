class Ramen extends Noodle {
  
  Ramen() {
    
    super(30.0, 0.3, "flat", "wheat flour");
    
  }
  
  @Override
  public String toString(){
    return "Ramen: Length = " + lengthInCentimeters + "cm, Width = " + widthInCentimeters + "cm, Shape = " + shape + ", Ingredients = " + ingredients + "\n";
  }

  public String getCookPrep() {
    
    return "Ramen: Boil ramen for 5 minutes in broth, then add meat, mushrooms, egg, and vegetables.";
    
  }
  
}
