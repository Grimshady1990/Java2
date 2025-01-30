/* This program is my own take on DNA.java. It still has the same functionality but we have added some different methods to gather the information.
Instead of having all our functions being built from the main method we have added methods for each dna string so it can be called more easily, and we have added all our dna samples to an ArrayList so we can call the function and it will produce the results for all of the samples.*/ 

// We need ArrayList in order to perform our loop.
import java.util.ArrayList;

public class PracDna{

// This Method is one of many so we can call the results without having to bloat our main method and can easily be called from child classes.
    public void dna1Meth(){
        String dna1 = "ATGCGATACGCTTGA";
        int start1 = dna1.indexOf("ATG");
        int end1 = dna1.indexOf("TGA");
        int length = dna1.length();
        if (start1 != -1 && end1 != -1 && (start1 - end1) % 3 == 0){
            String protein1 = dna1.substring(start1, end1+3);
            System.out.println("DNA SAMPLE: " + dna1 + " | LENGTH: " + length);
            System.out.println("protein: " + protein1);
            System.out.println("Conditions 1, 2, and 3 have been met.");
        }
        else {
            System.out.println("DNA SAMPLE: " + dna1 + " | LENGTH: " + length);
            System.out.println("No protein found!");
        }

    }
    public void dna2Meth(){
        String dna2  = "ATGCGATACGTGA";
        int start2 = dna2.indexOf("ATG");
        int end2 = dna2.indexOf("TGA");
        int length2 = dna2.length();
        if (start2 != -1 && end2 != -1 && (start2 - end2) % 3 == 0){
            String protein2 = dna2.substring(start2, end2+3);
            System.out.println("DNA SAMPLE: " + dna2 + " | LENGTH: " + length2);
            System.out.println("Protein: " + protein2);
            System.out.println("Conditions 1, 2, and 3 have been met.");
        }
        else{
            System.out.println("DNA SAMPLE: " + dna2 + " | LENGTH: " + length2);
            System.out.println("No protein found");
        }
    }
    public void dna3Meth(){
        String dna3 = "ATTAATATGTACTGA";
        int start3 = dna3.indexOf("ATG");
        int end3 = dna3.indexOf("TGA");
        int length3 = dna3.length();
        if (start3 != -1 && end3 != -1 && (start3 - end3) % 3 == 0){
            String protein3 = dna3.substring(start3, end3+3);
            System.out.println("DNA SAMPLE: " + dna3 + " | LENGTH: " + length3);
            System.out.println("Protein: " + protein3);
            System.out.println("Conditions 1, 2, and 3 have been met.");

        }
        else{
            System.out.println("DNA SAMPLE: " + dna3 + " | LENGTH: " + length3);
            System.out.println("No Protein Found!");
        }
    }
// This loop will run through all samples we have stored in the ArrayList and print all the results
    public void loopResults(){ 
        String[] dnaBunch = {"ATGCGATACGCTTGA","ATGCGATACGTGA","ATTAATATGTACTGA"};
        for (String dna : dnaBunch){
            int start = dna.indexOf("ATG");
            int end = dna.indexOf("TGA");
            if (start != -1 && end != -1  && (start - end) % 3 == 0){
                String protein = dna.substring(start, end+3);
                System.out.println("DNA SAMPLE: " + dna); 
                System.out.println("Protein Found: " + protein);
                System.out.println("Conditions 1, 2, and 3 have been met.");
            }
            else{
                System.out.println("DNA SAMPLE: " + dna);
                System.out.println("No protein found");
            }
        }
        
    }

 
    public static void main(String[] args){
        PracDna newMeth = new PracDna();
        newMeth.dna1Meth();
        System.out.println();
        newMeth.dna2Meth();
        System.out.println();
        newMeth.dna3Meth();
        System.out.println();
        newMeth.loopResults(); 
    }
}
// ATGCGATACGCTTGA
// ATGCGATACGTGA
// ATTAATATGTACTGA
