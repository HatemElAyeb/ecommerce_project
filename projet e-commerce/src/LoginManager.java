class LoginManager {
    private UserDatabase userDatabase;

    public LoginManager(UserDatabase userDatabase) {
        this.userDatabase = userDatabase;
    }

    public UserDatabase getUserDatabase() {
        return userDatabase;
    }

    public boolean login(String username, String password) {
        for (User user : userDatabase.getSignedInUsers()) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

}
