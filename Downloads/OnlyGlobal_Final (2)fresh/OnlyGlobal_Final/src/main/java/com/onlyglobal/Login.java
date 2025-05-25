// Login.java
package com.onlyglobal;

import java.util.regex.*;
import java.io.*;
import java.util.*;

public class Login {
    private String name;
    private String surname;
    private String username;
    private String password;
    private String phone;

    public Login(String name, String surname, String username, String password, String phone) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.phone = phone;
    }

    public boolean checkUserName() {
        return username.contains("_") && username.length() <= 5;
    }

    public boolean checkPasswordComplexity() {
        return password.length() >= 8 &&
               Pattern.compile("[A-Z]").matcher(password).find() &&
               Pattern.compile("[0-9]").matcher(password).find() &&
               Pattern.compile("[^a-zA-Z0-9]").matcher(password).find();
    }

    // Based on ChatGPT (OpenAI, 2024) regular expression pattern generation
    public boolean checkCellPhoneNumber() {
        return phone.matches("^\\+\\d{1,4}\\d{1,10}$");
    }

    public String registerUser() {
        if (!checkUserName()) {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length.";
        }
        if (!checkPasswordComplexity()) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }
        if (!checkCellPhoneNumber()) {
            return "Cell phone number incorrectly formatted or does not contain international code.";
        }

        try (FileWriter fw = new FileWriter("users.txt", true)) {
            fw.write(username + "," + password + "," + name + "," + surname + "," + phone + "\n");
        } catch (IOException e) {
            return "Error saving user.";
        }
        return "User registered successfully.";
    }

    public boolean loginUser(String enteredUsername, String enteredPassword) {
        try {
            Scanner sc = new Scanner(new File("users.txt"));
            while (sc.hasNextLine()) {
                String[] parts = sc.nextLine().split(",");
                if (parts.length >= 5 &&
                    parts[0].equals(enteredUsername) &&
                    parts[1].equals(enteredPassword)) {
                    this.name = parts[2];
                    this.surname = parts[3];
                    return true;
                }
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    public String returnLoginStatus(boolean success) {
        if (success) {
            return "Welcome " + name + ", " + surname + " it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}


