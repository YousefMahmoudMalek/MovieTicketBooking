package com.example.movieticket.ui;

import com.example.movieticket.model.SessionManager;
import javax.swing.*;
import java.awt.event.*;

public class LoginUI extends JFrame {
    private final JTextField userField = new JTextField(12);
    private final JPasswordField passField = new JPasswordField(12);
    private final JButton loginBtn = new JButton("Login");

    public LoginUI() {
        setTitle("Login");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel p = new JPanel();
        p.add(new JLabel("User:")); p.add(userField);
        p.add(new JLabel("Pass:")); p.add(passField);
        p.add(loginBtn);
        add(p);
        pack();
        setLocationRelativeTo(null);

        loginBtn.addActionListener(e -> onLogin());
    }

    private void onLogin() {
        String u = userField.getText().trim();
        String pw = new String(passField.getPassword());
        if (SessionManager.getInstance().login(u, pw)) {
            JOptionPane.showMessageDialog(this, "Welcome " + u);
            new HomeUI(u).setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Invalid credentials");
        }
    }
}
