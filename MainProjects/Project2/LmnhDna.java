import java.util.ArrayList;

public class LmnhDna {


    public void proteinTracker5000(String[] array) {

        for (String dna : array) {
            int start = dna.indexOf("ATG");
            int length = dna.length();
            if (start == -1) {
                System.out.println("DNA SEQUENCE: " + dna + " | LENGTH: " + length);
                System.out.println("No Protien Found");
                continue;
            }
            int end; 
            int endTGA = dna.indexOf("TGA", start + 3);
            int endTAA = dna.indexOf("TAA", start + 3);
            if (endTGA != -1) {
               end = endTGA;
            }
            else if (endTAA != -1) {
               end = endTAA;
            } 

            else {
                System.out.println("DNA SEQUENCE: " + dna + " | LENGTH: " + length);
                System.out.println("No Protien Found");
                continue;
 
            }
        
            if ((end - start + 3) % 3 == 0) {
                String protein = dna.substring(start, end + 3);
                System.out.println("DNA SEQUENCE: " + dna + " | LENGTH: " + length);

                System.out.println("Protein Found: " + protein);
        
        }
            else {
                System.out.println("DNA SEQUENCE: " + dna + " | LENGTH: " + length);
                System.out.println("No Protien Found");
 
    }
    }
    }

    public static void main(String[] args) {



        
     String[] group1 = {
            "ATGCGATACGCTTGA", // This sequence has a valid protein.
            "GCTAGCTAGGCTA",   // This sequence does not contain a valid protein.
            "ATGTACGATGTGA"    // This sequence does not contain a valid protein.
        };

        String[] group2 = {
            "ATTAATATGTACTGA",  // This sequence has a valid protein.
            "CGTACGATCG",       // This sequence does not contain a valid protein.
            "ATGCGTACGTGA",     // This sequence has a valid protein.
            "TGAATCGTACG"       // This sequence does not contain a valid protein.
        };

        String[] group3 = {
            "ATGCTAGCTGACTGA",  // This sequence does not contain a valid protein.
            "TACGATCGT",        // This sequence does not contain a valid protein.
            "ATCGATCGATGCA"     // This sequence does not contain a valid protein.
        };

        String[] group4 = {
            "ATGTACGAGTGA",     // This sequence has a valid protein.
            "CGTACGTAGC",       // This sequence does not contain a valid protein.
            "ATGTGCGTGA",       // This sequence does not contain a valid protein.
            "ATCGTACGATCGA"     // This sequence does not contain a valid protein.
        };

        String[] group5 = {
            "ATGCTACGTGA",      // This sequence does not contain a valid protein.
            "ATGCGTACGTGA",     // This sequence has a valid protein.
            "ATCGTACGAT",       // This sequence does not contain a valid protein.
            "CGTACGATCGTA",     // This sequence does not contain a valid protein.
            "ATGCGTACG",        // This sequence does not contain a valid protein.
            "ATGCGTACGTAA"      // This sequence has a valid protein.
        };

        
        LmnhDna ph = new LmnhDna();

        ph.proteinTracker5000(group4);

    }
}
