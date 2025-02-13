    //  -. .-.   .-. .-.   .
    //    \   \ /   \   \ /
    //   / \   \   / \   \
    //  ~   `-~ `-`   `-~ `-

public class PracDna {


    // This method processes an array of DNA sequences and checks if each contains a valid protein.
    // A protein is valid if it starts with "ATG" (start codon) and ends with either "TGA" or "TAA" (stop codon).
    public void proteinTracker(String[] array) {
        for (String dna : array) {
            // Find the position of the start codon "ATG".
            int start = dna.indexOf("ATG");

            // If no start codon is found, skip to the next DNA sequence.
            if (start == -1) {
                System.out.println("DNA SAMPLE: " + dna + " LENGTH: " + dna.length());
                System.out.println("No Protein Found :(");
                System.out.println();
                continue;
            }

            // Find the position of the stop codons "TGA" and "TAA" after the start codon.
            int endTGA = dna.indexOf("TGA", start + 3);  // Search after the start codon
            int endTAA = dna.indexOf("TAA", start + 3);  // Search after the start codon

            // Determine the position of the first valid stop codon (either TGA or TAA).
            int end = -1;
            if (endTGA != -1 && (endTAA == -1 || endTGA < endTAA)) {
                end = endTGA;
            } else if (endTAA != -1) {
                end = endTAA;
            }

            // If no stop codon is found, skip to the next DNA sequence.
            if (end == -1) {
                System.out.println("DNA SAMPLE: " + dna + " LENGTH: " + dna.length());
                System.out.println("No Protein Found :(");
                System.out.println();
                continue;
            }

            // Check if the length from the start codon to the stop codon (inclusive) is divisible by 3.
            int proteinLength = (end - start + 3);  // Include stop codon in length
            if (proteinLength % 3 == 0) {
                // Extract the protein sequence, including the stop codon.
                String protein = dna.substring(start, end + 3);
                System.out.println("DNA SAMPLE: " + dna + " LENGTH: " + dna.length());
                System.out.println("Protein Found: " + protein);
                System.out.println();
            } else {
                // If the length is not divisible by 3, print no protein found.
                System.out.println("DNA SAMPLE: " + dna + " LENGTH: " + dna.length());
                System.out.println("No Protein Found :(");
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {

        // Example DNA groups to be checked for proteins
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

        // Create an instance of the PracDna class and call the proteinTracker method for each DNA group.
        PracDna proteinHunter = new PracDna();
        proteinHunter.proteinTracker(group1);
        proteinHunter.proteinTracker(group2);
        proteinHunter.proteinTracker(group3);
        proteinHunter.proteinTracker(group4);
        proteinHunter.proteinTracker(group5);
    }
}

