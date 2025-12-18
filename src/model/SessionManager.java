package com.example.movieticket.model;

import java.util.*;

public class SessionManager {
    private static final SessionManager INSTANCE = new SessionManager();
    private final Map<String, String> users = new HashMap<>(); // username -> password
    private final Set<String> authenticated = new HashSet<>();

    private SessionManager() {
        // hardcoded users
        users.put("alice", "pass1");
        users.put("bob", "pass2");
    }

    public static SessionManager getInstance() { return INSTANCE; }

    public boolean login(String username, String password) {
        if (users.containsKey(username) && users.get(username).equals(password)) {
            authenticated.add(username);
            return true;
        }
        return false;
    }

    public void logout(String username) { authenticated.remove(username); }

    public boolean isAuthenticated(String username) { return authenticated.contains(username); }

    // allow new user registration
    public synchronized boolean register(String username, String password) {
        if (users.containsKey(username)) return false;
        users.put(username, password);
        return true;
    }
}
