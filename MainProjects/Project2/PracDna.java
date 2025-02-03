
// This version of Project2 is different from the original because we have converted it into a loop.
// By using a loop, we can check for proteins more efficiently, allowing us to process multiple DNA samples in a single run.

import java.util.ArrayList;

public class PracDna{

// This method takes a string array as the parameter and loops through each DNA sample.
// We use a for-each loop to go through the array of DNA sequences.
// Two integers, 'start' and 'end', are used to find the positions of the start ("ATG") and stop ("TGA") codons in the DNA sequence.
// The 'length' variable is used to store the length of the current DNA sequence for context.
// The 'if' statement checks if both start and end codons are found ('-1' means not found),
// and ensures that the distance between the start and end codons is divisible by 3 (for a valid protein sequence).
// The 'protein' string is created using 'substring(start, end + 3)', which ensures the stop codon is included in the sequence.
// If the conditions are met, the protein sequence is printed along with the DNA sample and its length.
// If the conditions are not met, a message indicating "No Protein Found" is printed.
    public void proteinTracker(String[] array){
        for (String dna : array){
            int start = dna.indexOf("ATG");
            int end = dna.indexOf("TGA");
            int length = dna.length();
            if (start != -1 && end != -1 && (end - start) % 3 == 0){
                String protein = dna.substring(start, end + 3);
                System.out.println("DNA SAMPLE: " + dna + " LENGTH: " + length);
                System.out.println("Protein Found: " + protein);
                System.out.println();

            }
            else{
                System.out.println("DNA SAMPLE: " + dna + " LENGTH: " + length);
                System.out.println("No Protein Found :(");
                System.out.println();
            }
        }
    }

    public static void main(String[] args){

        String[] group1 = {
            "ATGCGATACGCTTGA",
            "GCTAGCTAGGCTA",
            "ATGTACGATGTGA"
        };

        String[] group2 = {
            "ATTAATATGTACTGA",
            "CGTACGATCG",
            "ATGCGTACGTGA",
            "TGAATCGTACG"
        };


        
        String[] group3 = {
            "ATGCTAGCTGACTGA",
            "TACGATCGT",
            "ATCGATCGATGCA"
        };

        String[] group4 = {
            "ATGTACGAGTGA",
            "CGTACGTAGC",
            "ATGTGCGTGA",
            "ATCGTACGATCGA"
        };

        String[] group5 = {
            "ATGCTACGTGA",
            "ATGCGTACGTGA",
            "ATCGTACGAT",
            "CGTACGATCGTA",
            "ATGCGTACG",
            "ATGCGTACGTAA"
        };

        PracDna proteinHunter = new PracDna();
        proteinHunter.proteinTracker(group1);
        proteinHunter.proteinTracker(group2);
        proteinHunter.proteinTracker(group3);
        proteinHunter.proteinTracker(group4);
        proteinHunter.proteinTracker(group5);

    }
}
