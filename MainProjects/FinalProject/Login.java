public class Login {

    private UserAccounts userAccounts;

    public Login(UserAccounts userAccounts) {
        this.userAccounts = userAccounts;
    }

    public boolean authenticate(String username, String pin) {
        if (userAccounts.getUsers().containsKey(username)) {
            if (userAccounts.getUsers().get(username).equals(pin)) {
                System.out.println("Login successful! Welcome, " + username + "!");
                return true;
            } else {
                System.out.println("Incorrect PIN. Try again.");
            }
        } else {
            System.out.println("Username not found. Please register first.");
        }
        return false;
    }
}
