package hospital.userview;

import hospital.models.User;

import java.util.List;

public class UserView {

    public void displayUsers(List<User> users) {

        if (users == null || users.isEmpty()) {
            System.out.println();
            System.out.println("No users found.");
            return;
        }

        System.out.println();
        System.out.println("========================================================================================");
        System.out.printf("%-6s %-20s %-24s %-10s%n", "ID", "USERNAME", "ROLE", "STATUS");
        System.out.println("========================================================================================");

        for (User u : users) {
            System.out.printf("%-6d %-20s %-24s %-10s%n",
                    u.getId(), u.getUsername(), u.getRole(),
                    u.isActive() ? "ACTIVE" : "INACTIVE");
        }

        System.out.println("========================================================================================");
    }

    public void displayProfile(User user) {

        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        System.out.println();
        System.out.println("==============================================");
        System.out.println("              MY PROFILE");
        System.out.println("==============================================");
        System.out.println("Username: " + user.getUsername());
        System.out.println("Role    : " + user.getRole());
        System.out.println("Status  : " + (user.isActive() ? "ACTIVE" : "INACTIVE"));
        System.out.println("==============================================");
    }

    public void displayUserCreated() {
        System.out.println();
        System.out.println("User created successfully.");
    }

    public void displayPasswordChanged() {
        System.out.println();
        System.out.println("Password changed successfully.");
    }

    public void displayActionResult(boolean success, String action) {
        System.out.println();
        System.out.println(success ? action + " succeeded." : action + " failed.");
    }
}
