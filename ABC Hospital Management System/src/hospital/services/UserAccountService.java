package hospital.services;

import hospital.dao.UserDAO;
import hospital.models.User;

import java.util.List;

public class UserAccountService {

    private final UserDAO userDAO;
    private final AuthService authService;

    public UserAccountService() {
        userDAO = new UserDAO();
        authService = new AuthService();
    }

    public boolean createUser(User user) {

        if (user == null) {
            System.out.println("User cannot be null.");
            return false;
        }

        if (user.getUsername() == null || user.getUsername().trim().isEmpty()) {
            System.out.println("Username is required.");
            return false;
        }

        if (userDAO.findByUsername(user.getUsername()).isPresent()) {
            System.out.println("Username already exists.");
            return false;
        }

        userDAO.add(user);
        return true;
    }

    public List<User> getAllUsers() {
        return userDAO.findAll();
    }

    public User getUserByUsername(String username) {
        return userDAO.findByUsername(username).orElse(null);
    }

    public boolean deactivateUser(String username) {
        User user = getUserByUsername(username);
        if (user == null) {
            System.out.println("User not found.");
            return false;
        }
        user.setActive(false);
        return true;
    }

    public boolean activateUser(String username) {
        User user = getUserByUsername(username);
        if (user == null) {
            System.out.println("User not found.");
            return false;
        }
        user.setActive(true);
        return true;
    }

    public boolean resetPassword(String username, String newPassword) {
        User user = getUserByUsername(username);
        if (user == null) {
            System.out.println("User not found.");
            return false;
        }
        user.setPasswordHash(newPassword);
        return true;
    }

    public boolean changePassword(User user, String oldPassword, String newPassword) {
        return authService.changePassword(user, oldPassword, newPassword);
    }
}
