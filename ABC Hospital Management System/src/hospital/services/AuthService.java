package hospital.services;

import hospital.dao.UserDAO;
import hospital.models.User;

public class AuthService {

    private final UserDAO userDAO;

    public AuthService() {
        userDAO = new UserDAO();
    }

    // Note: passwords are compared as plain text for this demo project
    // (no hashing library is wired in). User.getPasswordHash() is used
    // as a plain-text credential store, matching the seed data.
    public User login(String username, String password) {

        if (username == null || username.trim().isEmpty()) {
            System.out.println("Username is required.");
            return null;
        }

        User user = userDAO.findByUsername(username).orElse(null);

        if (user == null) {
            System.out.println("Invalid username or password.");
            return null;
        }

        if (!user.isActive()) {
            System.out.println("This account is inactive.");
            return null;
        }

        if (!user.getPasswordHash().equals(password)) {
            System.out.println("Invalid username or password.");
            return null;
        }

        return user;
    }

    public boolean changePassword(User user, String oldPassword, String newPassword) {

        if (user == null) {
            System.out.println("No logged-in user.");
            return false;
        }

        if (!user.getPasswordHash().equals(oldPassword)) {
            System.out.println("Current password is incorrect.");
            return false;
        }

        user.setPasswordHash(newPassword);
        return true;
    }
}
