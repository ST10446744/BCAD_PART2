package com.onlyglobal;

import javax.swing.*;
import java.util.*;
import java.io.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Message {
    private String messageID;
    private static int messageCount = 0;
    private String recipient;
    private String message;
    private String hash;
    private static List<Message> sentMessages = new ArrayList<>();

    public Message(String messageID, String recipient, String message) {
        this.messageID = messageID;
        this.recipient = recipient;
        this.message = message;
        messageCount++;
        this.hash = createMessageHash();
    }

    public boolean checkMessageID() {
        return messageID.length() == 10;
    }

    public boolean checkRecipientCell() {
        return recipient.matches("^\\+\\d{1,4}\\d{1,10}$");
    }

    public String createMessageHash() {
        String[] words = message.trim().split("\\s+");
        String firstWord = words.length > 0 ? words[0] : "";
        String lastWord = words.length > 1 ? words[words.length - 1] : firstWord;
        return (messageID.substring(0, 2) + ":" + messageCount + ":" + firstWord + lastWord).toUpperCase();
    }

    public String sentMessage() {
        String[] options = {"Send Message", "Disregard Message", "Store Message to send later"};
        int choice = JOptionPane.showOptionDialog(null, "Choose an action", "Message Options",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        switch (choice) {
            case 0: sentMessages.add(this); return "Message sent";
            case 1: return "Message disregarded";
            case 2: storeMessage(); return "Message stored for later";
            default: return "Invalid option";
        }
    }

    public void storeMessage() {
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("MessageID", messageID);
        jsonObject.put("MessageHash", hash);
        jsonObject.put("Recipient", recipient);
        jsonObject.put("Message", message);
        jsonArray.add(jsonObject);

        try (FileWriter file = new FileWriter("messages.json", true)) {
            file.write(jsonArray.toJSONString());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Failed to store message: " + e.getMessage());
        }
    }

    public static String printMessages() {
        StringBuilder output = new StringBuilder();
        for (Message m : sentMessages) {
            output.append("MessageID: ").append(m.messageID)
                  .append("\nMessage Hash: ").append(m.hash)
                  .append("\nRecipient: ").append(m.recipient)
                  .append("\nMessage: ").append(m.message).append("\n\n");
        }
        return output.toString();
    }

    public static int returnTotalMessages() {
        return sentMessages.size();
    }
}

