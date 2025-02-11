// 🚀 Welcome to your interactive Java coding practice! Follow the guided steps below to write your code from scratch.



// 🎯 Step 1: Define a public class
// Every Java program starts with a class definition. Give your class an appropriate name.
// 💡 Hint: Use PascalCase for class names.
// 💡 Hint: Place the closing curly bracket of your public class at the bottom of the page.
// 💡 Hint: Public class names must match the file name.
// ✍️ Type your code below this comment
public class FinTempDna {


// 🎯 Step 2: Create a method to analyze genetic sequences
// This method should:
// ✅ Accept an array of DNA sequences as input
// ✅ Loop through each sequence in the array
// ✅ Identify a key segment within the sequence
// ✅ If the key segment is missing, print an appropriate message
// ✅ Otherwise, search for specific markers that determine validity
// ✅ Print whether a valid pattern was found or not
// 💡 Hint: Use string methods to find specific substrings in the sequence.
// ✍️ Type your code below this comment

    public void arrayLoop(String[] array) {
        
        for(String dna : array) {
            start = dna.indexOf("ATG");
            end = dna.indexOf("TGA", "TAA");
            lenght = dna.lenght();
            if (start == -1 && end == -1) {
                protein = dna.subString((start - end + 3) % 3 == 0);
                System.out.println("Protien Found: " + protein);
            }

        } 
    }

// 🎯 Step 3: Identify start and stop markers in a sequence
// ✅ Locate a key starting marker within each sequence
// ✅ If no starting marker is found, move to the next sequence
// ✅ Find possible ending markers after the starting position
// ✅ Determine the closest valid ending marker
// ✅ If no valid ending marker is found, print an appropriate message
// 💡 Hint: Multiple ending markers may exist; choose the first valid one.
// ✍️ Type your code below this comment



// 🎯 Step 4: Validate the length of the identified segment
// ✅ Calculate the length between the starting and ending markers
// ✅ Check if the length is a multiple of a specific number
// ✅ If valid, extract and print the relevant segment
// ✅ Otherwise, print an appropriate message
// 💡 Hint: Use the modulus operator (%) to check divisibility.
// ✍️ Type your code below this comment



// 🎯 Step 5: Implement a main method to test the analysis
// ✅ Define multiple test arrays containing DNA sequences
// ✅ Create an instance of your class
// ✅ Call the method to process each test array
// ✅ Print the results for validation
// 💡 Hint: Ensure sequences with and without valid patterns are tested.
// ✍️ Type your code below this comment

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

        FinTempDna dr1 = new FinTempDna();
        dr1.arrayLoop(group1);
       
    }

// 🎉 Great job! Run your code and check if everything works as expected. Debug if needed!


}
