import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
class UserDatabase {
    private List<User> signedInUsers;

    public UserDatabase() {
        this.signedInUsers = new ArrayList<>();
    }

    public void addUser(User user) {
        signedInUsers.add(user);
    }
    public User getuser(String username) {
        for (User user : signedInUsers) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_RESET = "\u001B[0m";
    public void showAllUsersInformation() {
        if (signedInUsers.isEmpty()) {
            System.out.println("No users to display.");
            return;
        }

        System.out.println(ANSI_GREEN+"All Users Information:"+ANSI_RESET);
        System.out.println("------------------------------");
        for (User user : signedInUsers) {
            System.out.println("Username: " + user.getUsername());
            System.out.println("Role: " + user.getRole());
            System.out.println("------------------------------");
        }
    }
    public void deleteUserByUsername(String username) {
        Iterator<User> iterator = signedInUsers.iterator();

        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user.getUsername().equals(username)) {
                iterator.remove(); // Remove the user
                System.out.println("User deleted successfully.");
                return;
            }
        }

        // If the loop completes without finding the user
        System.out.println("User not found. Deletion failed.");
    }
    public boolean userExists(String username) {
        for (User user : signedInUsers) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public List<User> getSignedInUsers() {
        return signedInUsers;
    }
}
