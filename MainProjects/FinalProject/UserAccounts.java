import java.io.*;

import java.util.Base64;

import java.util.HashMap;

public class UserAccounts {

    private HashMap<String, String> users = new HashMap<>();
    public HashMap<String, UserWallet> wallets = new HashMap<>();
    private final String FILE_NAME = "ZZUsers.txt";

    public UserAccounts() {
        loadAccounts();
    }

    public void registerUser(String username, String pin) {
        if (users.containsKey(username)) {
            System.out.println("Username already exists! Choose a different username.");
            return;
        }

        users.put(username,pin);
        UserWallet newWallet = new UserWallet();
        wallets.put(username, newWallet);
        System.out.println("User registered: " + username);
        saveAccounts();
    }

    public HashMap<String, String> getUsers() {
        return users;
    }

    public HashMap<String, UserWallet> getWallets() {
        return wallets;
    }


        public void saveAccounts() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (String username : users.keySet()) {
                String userPin = users.get(username);
                UserWallet userWallet = wallets.get(username);
                if (userWallet != null) {

                    String encryptedPin = Base64.getEncoder().encodeToString(userPin.getBytes());
                    // Serialize the wallet data as a string
                    String walletData = userWallet.getWalletAsString();

                    // Save username, pin, and wallet data to the file
                    writer.println(username + "," + encryptedPin + "," + walletData); // Save in CSV format
                 //   System.out.println("Saving account: " + username + " with wallet: " + walletData + " with encryptedPin:" + encryptedPin); // Debugging print statement

            }
        } 

        }
        catch (IOException e) {
            System.out.println("Error saving accounts");
        }
    }

    private void loadAccounts() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 3) {
                    String username = parts[0].trim();
                    String encryptedPin = parts[1].trim();
                    String walletData = parts[2].trim();
                 //   System.out.println("Username: " + username);
                //    System.out.println("PIN: " + encryptedPin);
               //     System.out.println("Wallet Data: " + walletData);

                    String decodePin = new String(Base64.getDecoder().decode(encryptedPin));

                    users.put(username, decodePin);

                    UserWallet wallet = wallets.get(username);
                    if (wallet == null) {
                        wallet = new UserWallet();
                        wallets.put(username, wallet);

                    }
                    wallet.loadWalletFromString(walletData);
                }    
                
            }
        } catch (IOException e) {
            System.out.println("Error loading accounts.");
        
          }

    }
}
