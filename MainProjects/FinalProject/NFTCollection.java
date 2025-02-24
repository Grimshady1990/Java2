import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class NFTCollection  {
    private static final String[] NFT_FILES = {"ZZnft1.txt", "ZZnft2.txt", "ZZnft3.txt"};

    public void showNFTMenu(Scanner scanner) {
        while (true) {
            System.out.println("\n==== NFT COLLECTION ====");
            System.out.println("[1] View NFT 1");
            System.out.println("[2] View NFT 2");
            System.out.println("[3] View NFT 3");
            System.out.println("[4] Back to User Menu");
            System.out.print("Choose an option: ");
            
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                case "2":
                case "3":
                    displayNFT(Integer.parseInt(choice));
                    break;
                case "4":
                    return; // Return to the main user menu
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }

    private void displayNFT(int nftNumber) {
        if (nftNumber < 1 || nftNumber > NFT_FILES.length) {
            System.out.println("Invalid NFT selection.");
            return;
        }
        try {
            String art = new String(Files.readAllBytes(Paths.get(NFT_FILES[nftNumber - 1])));
            System.out.println("\n==== NFT " + nftNumber + " ====");
            System.out.println(art);
        } catch (IOException e) {
            System.out.println("Error loading NFT: " + e.getMessage());
        }
    }
}

