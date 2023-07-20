package JavaBasics.a8_Network;

import java.util.ArrayList;
import java.util.List;

public class BasicAuthorization {
    public static void main(String[] args) {
        AuthorizationService authService = new AuthorizationService();

        // Simulate user login (you would typically have a login process in your application)
        User user = new User("alice", "password123", "admin");
        String action = "adminAction";                  // Check if the user is authorized to perform an action
        if (authService.isAuthorized(user, action)) {
            System.out.println("User is authorized to perform the action: " + action);
        } else {
            System.out.println("User is not authorized to perform the action: " + action);
        }
    }
}

class AuthorizationService {
    private List<User> users;

    public AuthorizationService() {
        users = new ArrayList<>();
        users.add(new User("alice", "password123", "admin"));
        users.add(new User("bob", "qwerty", "user"));
    }

    public boolean isAuthorized(User user, String action) {
        // In a real application, you would perform more complex logic here, e.g., checking roles against a database
        if (user == null || action == null) {
            return false;
        }

        // For this example, let's assume only the admin role is authorized to perform the action "adminAction"
        return action.equals("adminAction") && user.getRole().equals("admin");
    }
}

// User class representing a user with name, password, and role
class User {
    private String name;
    private String password;
    private String role;

    public User(String name, String password, String role) {
        this.name = name;
        this.password = password;
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}