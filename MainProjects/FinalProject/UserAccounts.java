import java.io.*;
import java.net.SocketOption;
import java.sql.Savepoint;
import java.util.HashMap;

public class UserAccounts {

    private HashMap<String, String> users = new HashMap<>();
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
        System.out.println("User registered: " + username);
        saveAccounts();
    }

    public HashMap<String, String> getUsers() {
        return users;
    }

    private void saveAccounts() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (String username : users.keySet()) {
                writer.println(username + "," + users.get(username));
            }
        } catch (IOException e) {
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
                if (parts.length == 2) {
                    users.put(parts[0], parts[1]);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading accounts.");
        }
    }
}
