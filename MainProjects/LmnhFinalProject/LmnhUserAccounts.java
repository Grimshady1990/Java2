import java.io.*;
import java.util.Base64;
import java.util.HashMap;

public class LmnhUserAccounts {

    private HashMap<String, String> users = new HashMap<>();

    public HashMap<String, LmnhUserWallet> wallets = new HashMap<>();

    private final String FILE_NAME = "ZZLmnhUsers.txt";

    public LmnhUserAccounts() {
        loadAccounts();
    }


    public void registerUser(String username, String pin) {

        if (users.containsKey(username)) {
            System.out.println("Username already exists! Choose a different username.");
            return;
        }

        users.put(username, pin);

        LmnhUserWallet newWallet = new LmnhUserWallet();
        wallets.put(username, newWallet);

        System.out.println("User registered: " + username);

        saveAccounts();

    }

    public HashMap<String, String> getUsers() {
        return users;
    }

    public HashMap<String, LmnhUserWallet> getWallets() {
        return wallets;
    }


    public void saveAccounts() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (String username : users.keySet()) {
                String userPin = users.get(username);
                LmnhUserWallet userWallet = wallets.get(username);

                if (userWallet != null) {

                    String encryptionPin = Base64.getEncoder().encodeToString(userPin.getBytes());

                    String walletData = userWallet.getWalletAsString();

                    writer.println(username + "," + encryptionPin + "," + walletData);
                }
            }
        } catch (IOException e) {
            System.out.println("Error Saving accounts");
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

                    String decodePin = new String(Base64.getDecoder().decode(encryptedPin));

                    users.put(username, decodePin);

                    LmnhUserWallet wallet = wallets.get(username);
                }
            }
        }   catch (IOException e) {
            System.out.println("Error loading accounts.");
        }
    }
}
