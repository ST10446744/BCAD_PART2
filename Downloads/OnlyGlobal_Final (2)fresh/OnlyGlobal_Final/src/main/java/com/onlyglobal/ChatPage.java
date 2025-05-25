package com.onlyglobal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChatPage {
    public static void main(String[] args) {
        JFrame frame = new JFrame("OnlyGlobal - Chat");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        // Outer panel for clean separation
        JPanel outerPanel = new JPanel();
        outerPanel.setBackground(Color.WHITE);
        outerPanel.setLayout(new BorderLayout());
        frame.add(outerPanel);

        // Contacts panel on the left
        JPanel contactsPanel = new JPanel();
        contactsPanel.setPreferredSize(new Dimension(250, 600));
        contactsPanel.setBackground(new Color(240, 240, 240));
        contactsPanel.setLayout(new BoxLayout(contactsPanel, BoxLayout.Y_AXIS));

        JLabel contactsLabel = new JLabel("Contacts");
        contactsLabel.setFont(new Font("Arial", Font.BOLD, 18));
        contactsLabel.setForeground(new Color(0, 149, 246));
        contactsPanel.add(contactsLabel);

        // Sample contacts (You can dynamically add them later)
        String[] contactNames = {"John Doe", "Jane Smith", "Mark Allen", "Emily Clark"};
        for (String name : contactNames) {
            JButton contactButton = new JButton(name);
            contactButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            contactButton.setBackground(Color.WHITE);
            contactButton.setForeground(new Color(0, 149, 246));
            contactButton.setFont(new Font("Arial", Font.PLAIN, 16));
            contactButton.setBorder(BorderFactory.createLineBorder(new Color(0, 149, 246)));
            contactButton.setFocusPainted(false);
            contactButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
            contactsPanel.add(contactButton);
        }

        // Chat panel in the center
        JPanel chatPanel = new JPanel();
        chatPanel.setLayout(new BorderLayout());
        chatPanel.setBackground(Color.WHITE);

        // Chat area to display messages
        JTextArea chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setFont(new Font("Arial", Font.PLAIN, 14));
        chatArea.setBackground(new Color(245, 245, 245));
        chatArea.setForeground(new Color(0, 0, 0));
        chatArea.setLineWrap(true);
        chatArea.setWrapStyleWord(true);
        JScrollPane chatScrollPane = new JScrollPane(chatArea);
        chatPanel.add(chatScrollPane, BorderLayout.CENTER);

        // Input field for typing messages
        JTextField inputField = new JTextField();
        inputField.setFont(new Font("Arial", Font.PLAIN, 14));
        inputField.setBackground(new Color(240, 240, 240));
        inputField.setForeground(new Color(0, 149, 246));
        inputField.setBorder(BorderFactory.createLineBorder(new Color(0, 149, 246)));
        chatPanel.add(inputField, BorderLayout.SOUTH);

        // Add panels to the outer panel
        outerPanel.add(contactsPanel, BorderLayout.WEST);
        outerPanel.add(chatPanel, BorderLayout.CENTER);

        // Send message when the enter key is pressed
        inputField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String message = inputField.getText();
                if (!message.isEmpty()) {
                    chatArea.append("You: " + message + "\n");
                    inputField.setText("");  // Clear the input field after sending
                }
            }
        });

        // Send message when clicking the send button
        JButton sendButton = new JButton("Send");
        sendButton.setBackground(new Color(0, 149, 246));
        sendButton.setForeground(Color.WHITE);
        sendButton.setFont(new Font("Arial", Font.BOLD, 16));
        sendButton.setFocusPainted(false);
        sendButton.setBorder(BorderFactory.createLineBorder(new Color(0, 149, 246)));
        sendButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        sendButton.setPreferredSize(new Dimension(80, 40));
        sendButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String message = inputField.getText();
                if (!message.isEmpty()) {
                    chatArea.append("You: " + message + "\n");
                    inputField.setText("");  // Clear the input field after sending
                }
            }
        });

        // Add the send button to the chat panel
        JPanel sendPanel = new JPanel();
        sendPanel.setLayout(new BorderLayout());
        sendPanel.setBackground(Color.WHITE);
        sendPanel.add(sendButton, BorderLayout.EAST);
        chatPanel.add(sendPanel, BorderLayout.SOUTH);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
