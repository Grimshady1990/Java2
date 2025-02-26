public class LmnhLogin {

    private LmnhUserAccounts lmnhUserAccounts;

    public LmnhLogin(LmnhUserAccounts lmnhUserAccounts) {
        this.lmnhUserAccounts = lmnhUserAccounts;
    }

    public boolean authenticate(String username, String pin) {
        if (lmnhuserAccounts.getUsers().containsKey(username)) {
            if (lmnhUserAccounts.getUsers().get(username).equals(pin)) {
                System.out.println("Login successful! Welcome, " + username + "!");
                return true;
            } else {
                System.out.println("Incorrect PIN. Try again.");
            }
        } else {
            System.out.println("User not found. Please register first.");
        }
        return false;
    }
}
