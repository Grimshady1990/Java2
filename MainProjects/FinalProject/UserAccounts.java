
import java.io.*;  
import java.util.Base64;  
import java.util.HashMap;  

public class UserAccounts {

    // Stores usernames and their corresponding PINs
    private HashMap<String, String> users = new HashMap<>();
    
    // Stores user wallets associated with each username
    public HashMap<String, UserWallet> wallets = new HashMap<>();
    
    // File where user accounts are saved
    private final String FILE_NAME = "ZZUsers.txt";

    /**
     * Constructor that loads existing user accounts from a file.
     */
    public UserAccounts() {
        loadAccounts();
    }

    /**
     * Registers a new user with a username and PIN.
     * - Checks if the username already exists.
     * - Creates a new wallet for the user.
     * - Saves the updated accounts to the file.
     *
     * @param username The username for the new account.
     * @param pin The PIN associated with the account.
     */
    public void registerUser(String username, String pin) {
        // Check if the username is already taken
        if (users.containsKey(username)) {
            System.out.println("Username already exists! Choose a different username.");
            return;
        }

        // Add the username and PIN to the users map
        users.put(username, pin);
        
        // Create a new wallet for the user
        UserWallet newWallet = new UserWallet();
        wallets.put(username, newWallet);
        
        System.out.println("User registered: " + username);
        
        // Save updated accounts to the file
        saveAccounts();
    }

    /**
     * Returns the map containing usernames and their PINs.
     */
    public HashMap<String, String> getUsers() {
        return users;
    }

    /**
     * Returns the map containing usernames and their associated wallets.
     */
    public HashMap<String, UserWallet> getWallets() {
        return wallets;
    }

    /**
     * Saves all user accounts and wallet data to a file.
     * - Encrypts the PIN using Base64 encoding.
     * - Converts wallet data into a string format for storage.
     * - Writes username, encrypted PIN, and wallet data in CSV format.
     */
    public void saveAccounts() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (String username : users.keySet()) {
                String userPin = users.get(username);
                UserWallet userWallet = wallets.get(username);
                
                if (userWallet != null) {
                    // Encrypt the PIN before saving
                    String encryptedPin = Base64.getEncoder().encodeToString(userPin.getBytes());
                    
                    // Convert wallet data to a string format for saving
                    String walletData = userWallet.getWalletAsString();

                    // Save data in CSV format: username, encrypted PIN, wallet data
                    writer.println(username + "," + encryptedPin + "," + walletData);
                }
            }
        } catch (IOException e) {
            System.out.println("Error saving accounts");
        }
    }

    /**
     * Loads user accounts from the saved file.
     * - Reads usernames, encrypted PINs, and wallet data.
     * - Decrypts the PIN using Base64 decoding.
     * - Restores wallets from their saved string representation.
     */
    private void loadAccounts() {
        File file = new File(FILE_NAME);
        
        // If the file does not exist, return early
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            
            while ((line = reader.readLine()) != null) {
                // Split the CSV data into parts (username, encrypted PIN, wallet data)
                String[] parts = line.split(",");
                
                if (parts.length >= 3) {
                    String username = parts[0].trim();
                    String encryptedPin = parts[1].trim();
                    String walletData = parts[2].trim();

                    // Decrypt the PIN
                    String decodePin = new String(Base64.getDecoder().decode(encryptedPin));

                    // Store the username and decrypted PIN
                    users.put(username, decodePin);

                    // Retrieve or create a new wallet for the user
                    UserWallet wallet = wallets.get(username);
                    if (wallet == null) {
                        wallet = new UserWallet();
                        wallets.put(username, wallet);
                    }

                    // Load the wallet data from the saved string
                    wallet.loadWalletFromString(walletData);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading accounts.");
        }
    }
}

