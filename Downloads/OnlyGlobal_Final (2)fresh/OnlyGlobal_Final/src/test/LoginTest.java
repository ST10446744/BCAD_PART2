package com.onlyglobal;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    @Test
    public void testCheckUserName_valid() {
        Login login = new Login();
        assertTrue(login.checkUserName("abc_"), "Should return true for valid username");
    }

    @Test
    public void testCheckUserName_invalid() {
        Login login = new Login();
        assertFalse(login.checkUserName("abcdef"), "Should return false for invalid username");
    }

    @Test
    public void testCheckPasswordComplexity_valid() {
        Login login = new Login();
        assertTrue(login.checkPasswordComplexity("Test@123"), "Should return true for valid password");
    }

    @Test
    public void testCheckPasswordComplexity_invalid() {
        Login login = new Login();
        assertFalse(login.checkPasswordComplexity("test123"), "Should return false for weak password");
    }

    @Test
    public void testCheckCellPhoneNumber_valid() {
        Login login = new Login();
        assertTrue(login.checkCellPhoneNumber("+271234567"), "Should return true for valid phone number");
    }

    @Test
    public void testCheckCellPhoneNumber_invalid() {
        Login login = new Login();
        assertFalse(login.checkCellPhoneNumber("1234567890"), "Should return false for missing country code");
    }
}



