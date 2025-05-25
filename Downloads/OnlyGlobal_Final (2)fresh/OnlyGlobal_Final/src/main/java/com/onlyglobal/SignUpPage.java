// SignUpPage.java
package com.onlyglobal;

import javax.swing.*;
import java.awt.*;

public class SignUpPage {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Sign Up - OnlyGlobal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new GridLayout(8, 2, 10, 10));
        frame.getContentPane().setBackground(Color.WHITE);

        JTextField nameField = new JTextField();
        JTextField surnameField = new JTextField();
        JTextField usernameField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JTextField phoneField = new JTextField();
        JButton signUp = new JButton("Sign Up");
        JButton toLogin = new JButton("Go to Login");

        frame.add(new JLabel("First Name:"));
        frame.add(nameField);
        frame.add(new JLabel("Surname:"));
        frame.add(surnameField);
        frame.add(new JLabel("Username:"));
        frame.add(usernameField);
        frame.add(new JLabel("Password:"));
        frame.add(passwordField);
        frame.add(new JLabel("Phone Number (+code):"));
        frame.add(phoneField);
        frame.add(new JLabel(""));
        frame.add(signUp);
        frame.add(new JLabel(""));
        frame.add(toLogin);

        signUp.setBackground(new Color(0, 149, 246));
        signUp.setForeground(Color.WHITE);

        toLogin.setBackground(Color.GRAY);
        toLogin.setForeground(Color.WHITE);

        signUp.addActionListener(e -> {
            String name = nameField.getText();
            String surname = surnameField.getText();
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            String phone = phoneField.getText();

            Login login = new Login(name, surname, username, password, phone);
            String result = login.registerUser();

            JOptionPane.showMessageDialog(frame, result);
        });

        toLogin.addActionListener(e -> {
            frame.dispose();
            LoginPage.main(null);
        });

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
