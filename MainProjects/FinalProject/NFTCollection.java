
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class NFTCollection {
    
    // An array of filenames representing stored NFT artworks. 
    // These text files contain ASCII art or descriptions of NFTs.
    private static final String[] NFT_FILES = {"ZZnft1.txt", "ZZnft2.txt", "ZZnft3.txt"};

    /**
     * Displays the NFT menu and allows the user to select an option.
     * The user can view different NFTs or go back to the main user menu.
     *
     * @param scanner Scanner object to read user input
     */
    public void showNFTMenu(Scanner scanner) {
        while (true) {
            // Display NFT menu options
            System.out.println("\n==== NFT COLLECTION ====");
            System.out.println("[1] View NFT 1");
            System.out.println("[2] View NFT 2");
            System.out.println("[3] View NFT 3");
            System.out.println("[4] Back to User Menu");
            System.out.print("Choose an option: ");

            // Read the user's choice
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                case "2":
                case "3":
                    // Convert the string choice into an integer and display the corresponding NFT
                    displayNFT(Integer.parseInt(choice));
                    break;
                case "4":
                    // Exit the NFT menu and return to the main user menu
                    return;
                default:
                    // Handle invalid input
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }

    /**
     * Reads and displays the content of the selected NFT file.
     *
     * @param nftNumber The number corresponding to the NFT file to be displayed
     */
    private void displayNFT(int nftNumber) {
        // Validate that the input is within the range of available NFT files
        if (nftNumber < 1 || nftNumber > NFT_FILES.length) {
            System.out.println("Invalid NFT selection.");
            return;
        }

        try {
            // Read the contents of the selected NFT file
            String art = new String(Files.readAllBytes(Paths.get(NFT_FILES[nftNumber - 1])));
            
            // Display the NFT artwork or description
            System.out.println("\n==== NFT " + nftNumber + " ====");
            System.out.println(art);
        } catch (IOException e) {
            // Handle cases where the file cannot be read (e.g., file missing or permission issues)
            System.out.println("Error loading NFT: " + e.getMessage());
        }
    }
}

