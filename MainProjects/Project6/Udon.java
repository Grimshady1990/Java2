class Udon extends Noodle{
  Udon(){
    super(50.0, 0.99, "round", "wheat flour");
  }

  @Override
  public String toString(){
    return "Udon: Length = " + lengthInCentimeters + "cm, Width = " + widthInCentimeters + "cm, Shape = " + shape + ", Ingredients = " + ingredients + "\n";
  }

  public String getCookPrep(){
    return "Udon: The dough is kneaded, rested, and then rolled out and cut into thick strips. The noodles are then boiled until tender";
  }

}
