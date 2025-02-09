/* 
    🔥 Your Ultimate Debugging Challenge: DbugDna Edition!

    Your mission: Find and fix **at least 12 major bugs** in this DNA protein analysis program!

    🛠️ Categories of Bugs:
    
    ⚡ Functional Bugs:
    - Bug #1: The method incorrectly detects valid proteins!
    - Bug #2: The stop codon detection logic is flawed!
    - Bug #3: The protein length check has an off-by-one error!
    - Bug #4: Some valid proteins are missed due to incorrect substring calculations!
    
    💥 Runtime Errors:
    - Bug #5: This code can crash due to an `IndexOutOfBoundsException`!
    - Bug #6: There is a risk of `NullPointerException`!
    - Bug #7: The loop might run indefinitely due to incorrect conditions!
    
    🔄 Logical Errors:
    - Bug #8: The order of checking stop codons is incorrect!
    - Bug #9: The `indexOf` method sometimes returns incorrect results!
    - Bug #10: The output format is inconsistent and messy!
    - Bug #11: Some test cases don't return expected results!
    - Bug #12: The DNA sequence processing logic is not efficient!

    💡 Debugging Tips:
    
    🧐 DNA sequences should only contain **A, T, C, G**!
    🔢 Be careful with **off-by-one errors** in substring calculations!
    🚨 **Null values** can cause crashes—handle them properly!
    ⚡ Test each method independently to **isolate the bugs**!
*/

public class DbugDna {

    // 🐛 Bug #1, #2, #3: The protein tracking logic is flawed!
    public void proteinTracker(String[] array) {
        for (String dna : array) {
            // 🐛 Bug #5: This can cause a crash if `dna` is null!
            if (dna == null) {
                System.out.println("Invalid DNA sequence: NULL");
                continue;
            }

            // Find the position of the start codon "ATG".
            int start = dna.indexOf("ATG");

            // If no start codon is found, print the DNA details and continue.
            if (start == -1) {
                System.out.println("DNA SAMPLE: " + dna + " LENGTH: " + dna.length());
                System.out.println("No Protein Found :(");
                System.out.println();
                continue;
            }

            // Find stop codons AFTER the start codon
            int endTGA = dna.indexOf("TGA");  // 🚨 Bug #4: Should start searching AFTER the start codon!
            int endTAA = dna.indexOf("TAA");  // 🚨 Bug #4: Should start searching AFTER the start codon!

            // Determine the earliest stop codon position
            int end = -1;
            if (endTGA < endTAA) { // 🚨 Bug #8: Incorrect condition! What if one of them is -1?
                end = endTGA;
            } else {
                end = endTAA;
            }

            // If no stop codon is found, continue.
            if (end == -1) {
                System.out.println("DNA SAMPLE: " + dna + " LENGTH: " + dna.length());
                System.out.println("No Protein Found :(");
                System.out.println();
                continue;
            }

            // Check if the protein length is divisible by 3
            int proteinLength = (end - start); // 🚨 Bug #3: Should include stop codon in length!
            if (proteinLength % 3 == 0) {
                // Extract the protein sequence
                String protein = dna.substring(start, end); // 🚨 Bug #9: Stop codon should be included!
                System.out.println("DNA SAMPLE: " + dna + " LENGTH: " + dna.length());
                System.out.println("Protein Found: " + protein);
                System.out.println();
            } else {
                System.out.println("DNA SAMPLE: " + dna + " LENGTH: " + dna.length());
                System.out.println("No Protein Found :(");
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {

        // Example DNA groups to be checked for proteins
        String[] group1 = {
            "ATGCGATACGCTTGA", // ✅ Expected: Protein Found
            "GCTAGCTAGGCTA",   // ❌ Expected: No Protein Found
            "ATGTACGATGTGA"    // ✅ Expected: Protein Found
        };

        String[] group2 = {
            "ATTAATATGTACTGA",  // ✅ Expected: Protein Found
            "CGTACGATCG",       // ❌ Expected: No Protein Found
            "ATGCGTACGTGA",     // ✅ Expected: Protein Found
            "TGAATCGTACG"       // ❌ Expected: No Protein Found
        };

        String[] group3 = {
            "ATGCTAGCTGACTGA",  // ❌ Expected: No Protein Found
            "TACGATCGT",        // ❌ Expected: No Protein Found
            "ATCGATCGATGCA"     // ❌ Expected: No Protein Found
        };

        String[] group4 = {
            "ATGTACGAGTGA",     // ✅ Expected: Protein Found
            "CGTACGTAGC",       // ❌ Expected: No Protein Found
            "ATGTGCGTGA",       // ❌ Expected: No Protein Found
            "ATCGTACGATCGA"     // ❌ Expected: No Protein Found
        };

        String[] group5 = {
            "ATGCTACGTGA",      // ❌ Expected: No Protein Found
            "ATGCGTACGTGA",     // ✅ Expected: Protein Found
            "ATCGTACGAT",       // ❌ Expected: No Protein Found
            "CGTACGATCGTA",     // ❌ Expected: No Protein Found
            "ATGCGTACG",        // ❌ Expected: No Protein Found
            "ATGCGTACGTAA"      // ✅ Expected: Protein Found
        };

        // Create an instance of the DbugDna class and call proteinTracker for each DNA group.
        DbugDna proteinHunter = new DbugDna();
        proteinHunter.proteinTracker(group1);
        proteinHunter.proteinTracker(group2);
        proteinHunter.proteinTracker(group3);
        proteinHunter.proteinTracker(group4);
        proteinHunter.proteinTracker(group5);
    }
}
