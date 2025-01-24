/* This is a Java that determines whether there is a protien in a strand of DNA.
Author :: Frankie Thomas
Date :: 24/01/25 */

public class DNA {
  
  public static void main(String[] args) {
    String dna1 = "ATGCGATACGCTTGA";
    String dna2 = "ATGCGATACGTGA";
    String dna3 = "ATTAATATGTACTGA";
    String dna = dna3;
    int length = dna.length();
    System.out.println("Length: " + length);
    int start = dna.indexOf("ATG");
    System.out.println("Start: " + start);
    int end = dna.indexOf("TGA");
    System.out.println("End: " + end);
    if (start != -1 && end != -1 && (start - end) % 3 == 0){
      String protein = dna.substring(start, end+3);
      System.out.println("Protein: " + protein);
      System.out.println("Condition 1, 2, and 3 are satisfied.");
    
    }
    else{
      System.out.println("No Protein.");
    }
    //  -. .-.   .-. .-.   .
    //    \   \ /   \   \ / 
    //   / \   \   / \   \  
    //  ~   `-~ `-`   `-~ `-
    
  }
  
}

