package com.onlyglobal;

import javax.swing.*;
import java.awt.*;

public class WelcomePage {
    public static void main(String[] args) {
        JFrame frame = new JFrame("OnlyGlobal - Welcome");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.WHITE);

        // Outer black panel for "expensive look"
        JPanel outerPanel = new JPanel();
        outerPanel.setBounds(20, 20, 560, 340);
        outerPanel.setBackground(Color.BLACK);
        outerPanel.setLayout(null);
        frame.add(outerPanel);

        // Inner white panel for content
        JPanel innerPanel = new JPanel();
        innerPanel.setBounds(5, 5, 550, 330);
        innerPanel.setBackground(Color.WHITE);
        innerPanel.setLayout(null);
        outerPanel.add(innerPanel);

        // OnlyGlobal title with 2-color style
        JLabel title = new JLabel();
        title.setBounds(160, 30, 300, 40);
        title.setFont(new Font("SansSerif", Font.BOLD, 34));
        title.setText("<html><span style='color:#8a3ab9;'>Only</span><span style='color:#0095f6;'>Global</span></html>");
        innerPanel.add(title);

        // Sign Up button
        JButton signupButton = new JButton("Sign Up");
        signupButton.setBounds(180, 100, 180, 45);
        signupButton.setBackground(new Color(255, 255, 255));
        signupButton.setForeground(new Color(0, 149, 246));
        signupButton.setFont(new Font("Arial", Font.BOLD, 16));
        signupButton.setFocusPainted(false);
        signupButton.setBorder(BorderFactory.createLineBorder(new Color(0, 149, 246), 2, true));
        signupButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        signupButton.setOpaque(true);
        innerPanel.add(signupButton);

        // Login button
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(180, 170, 180, 45);
        loginButton.setBackground(new Color(255, 255, 255));
        loginButton.setForeground(new Color(0, 149, 246));
        loginButton.setFont(new Font("Arial", Font.BOLD, 16));
        loginButton.setFocusPainted(false);
        loginButton.setBorder(BorderFactory.createLineBorder(new Color(0, 149, 246), 2, true));
        loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        loginButton.setOpaque(true);
        innerPanel.add(loginButton);

        // Button actions
        signupButton.addActionListener(e -> {
            frame.dispose();
            SignUpPage.main(null);
        });

        loginButton.addActionListener(e -> {
            frame.dispose();
            LoginPage.main(null);
        });

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
