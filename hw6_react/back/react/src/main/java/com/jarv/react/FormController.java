package com.jarv.react;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class FormController {


    private List<User> testUsers = new ArrayList<>();

    public FormController() {
    
        testUsers.add(new User("User", "user"));
        testUsers.add(new User("Admin", "admin"));
    }

    @PostMapping("/api/login")
    public Map<String, Object> login(@RequestBody Map<String, String> data) {
        String login = data.get("login");
        String email = data.get("password");

        boolean found = testUsers.stream()
                .anyMatch(u -> u.getLogin().equalsIgnoreCase(login) && u.getPassword().equalsIgnoreCase(email));

        if (found) {
            String token = "session-" + login + "-" + System.currentTimeMillis();
            return Map.of(
                    "success", true,
                    "message", "Login successful!",
                    "token", token
            );
        } else {
            return Map.of(
                    "success", false,
                    "message", "Invalid credentials"
            );
        }
    }
    @PostMapping("/api/register")
    @CrossOrigin(origins = "http://localhost:5173")
    public Map<String, Object> register(@RequestBody Map<String, String> data) {
        String login = data.get("login");
        String password = data.get("password");

        boolean exists = testUsers.stream()
                .anyMatch(u -> u.getLogin().equalsIgnoreCase(login));

        if (exists) {
            return Map.of("success", false, "message", "User already exists");
        }

        testUsers.add(new User(login, password));
        return Map.of("success", true, "message", "Registration successful");
    }

    static class User {
        private String login;
        private String password;

        public User(String login, String password) {
            this.login = login;
            this.password = password;
        }
        public String getLogin() { return login; }
        public String getPassword() { return password; }
    }
}
