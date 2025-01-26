class Pho extends Noodle {
  
  Pho() {
    
    super(30.0, 0.64, "flat", "rice flour");
    
  }
  
  @Override
  public String toString(){
    return "Pho: Length = " + lengthInCentimeters + "cm, Width = " + widthInCentimeters + "cm, Shape = " + shape + ", Ingredients = " + ingredients + "\n";
  }
  public String getCookPrep() {
    
    return "Pho: Soak pho for 1 hour, then boil for 1 minute in broth. Then garnish with cilantro and jalapeno.";
    
  }
  
}
