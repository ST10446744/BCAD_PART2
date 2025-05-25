package com.onlyglobal;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MessageTest {

    @Test
    public void testValidMessageLength() {
        Message msg = new Message("1234567890", "+27718693002", "Hi Mike, can you join us for dinner tonight?");
        assertEquals("Message sent", msg.sentMessage());
    }

    @Test
    public void testMessageTooLong() {
        String longMessage = "X".repeat(260); // 260 characters
        Message msg = new Message("1234567890", "+27718693002", longMessage);
        assertEquals("Message failed", msg.sentMessage());
    }

    @Test
    public void testCheckRecipientCellSuccess() {
        Message msg = new Message("1234567890", "+27718693002", "Test message");
        assertTrue(msg.checkRecipientCell());
    }

    @Test
    public void testCheckRecipientCellFailure() {
        Message msg = new Message("1234567890", "08575975889", "Test message");
        assertFalse(msg.checkRecipientCell());
    }

    @Test
    public void testCheckMessageIDValid() {
        Message msg = new Message("1234567890", "+27718693002", "Test message");
        assertTrue(msg.checkMessageID());
    }

    @Test
    public void testCheckMessageIDInvalid() {
        Message msg = new Message("1234", "+27718693002", "Test message");
        assertFalse(msg.checkMessageID());
    }

    @Test
    public void testCreateMessageHash() {
        Message msg = new Message("1234567890", "+27718693002", "Hash test");
        assertNotNull(msg.createMessageHash());
    }

    @Test
    public void testReturnTotalMessages() {
        int before = Message.returnTotalMessages();
        Message msg = new Message("1234567890", "+27718693002", "Counting message");
        msg.sentMessage();
        int after = Message.returnTotalMessages();
        assertEquals(before + 1, after);
    }
}

