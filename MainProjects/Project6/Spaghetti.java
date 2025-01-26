class Spaghetti extends Noodle {
  
  Spaghetti() {
    
  	super(30.0, 0.2, "round", "semolina flour");
    
  }
  
  @Override
  public String toString(){
    return "Spaghetti: Length = " + lengthInCentimeters + "cm, Width = " + widthInCentimeters + "cm, Shape = " + shape + ", Ingredients = " + ingredients + "\n";
  }
  public String getCookPrep() {
    
    return "Spaghetti: Boil spaghetti for 8 - 12 minutes and add sauce, cheese, or oil and garlic.";
    
  }
  
}
