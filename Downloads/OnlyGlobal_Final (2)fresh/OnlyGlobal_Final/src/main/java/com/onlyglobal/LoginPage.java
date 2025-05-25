package com.onlyglobal;

import javax.swing.*;
import java.awt.*;

public class LoginPage {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Login - OnlyGlobal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 200);
        frame.setLayout(new GridLayout(4, 2, 10, 10));
        frame.getContentPane().setBackground(Color.WHITE);

        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JButton loginBtn = new JButton("Login");

        frame.add(new JLabel("Username:"));
        frame.add(usernameField);
        frame.add(new JLabel("Password:"));
        frame.add(passwordField);
        frame.add(new JLabel(""));
        frame.add(loginBtn);

        loginBtn.setBackground(new Color(0, 149, 246));
        loginBtn.setForeground(Color.WHITE);

        loginBtn.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            Login login = new Login("", "", "", "", "");
            boolean isValid = login.loginUser(username, password);
            String message = login.returnLoginStatus(isValid);

            JOptionPane.showMessageDialog(frame, message);

            if (isValid) {
                frame.dispose();       // Close the Login GUI
                // Launch QuickChat console app
                QuickChat.main(null); 
            }
        });

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

