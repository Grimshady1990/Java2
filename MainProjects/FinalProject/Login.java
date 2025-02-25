
public class Login {

    // This class is responsible for handling user authentication. 
    // It verifies whether a given username and PIN match the records in the system.

    // A reference to the UserAccounts class, which stores all registered users and their PINs.
    private UserAccounts userAccounts;

    // Constructor: Initializes the Login class with an instance of UserAccounts.
    // This allows the Login class to access stored user credentials.
    public Login(UserAccounts userAccounts) {
        this.userAccounts = userAccounts;
    }
    
    // This method checks if the provided username and PIN are correct.
    // It first verifies if the username exists in the userAccounts database.
    // If the username exists, it then checks if the associated PIN matches the input.
    // If both conditions are met, authentication is successful, and a success message is displayed.
    // If the PIN is incorrect, it prompts the user to try again.
    // If the username is not found, it advises the user to register first.
    public boolean authenticate(String username, String pin) {
        if (userAccounts.getUsers().containsKey(username)) { // Checks if the username exists in the database
            if (userAccounts.getUsers().get(username).equals(pin)) { // Checks if the stored PIN matches the entered PIN
                System.out.println("Login successful! Welcome, " + username + "!");
                return true; // Returns true when authentication is successful
            } else {
                System.out.println("Incorrect PIN. Try again."); // Informs the user that the PIN is incorrect
            }
        } else {
            System.out.println("Username not found. Please register first."); // Informs the user that the account does not exist
        }
        return false; // Returns false if authentication fails
    }
}

