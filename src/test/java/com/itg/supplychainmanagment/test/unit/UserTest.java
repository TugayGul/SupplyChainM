package com.itg.supplychainmanagment.test.unit;

import com.itg.supplychainmanagment.entity.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {
    @Test
    public void testGettersAndSetters() {
        // arrange
        User user = new User();
        Long userId = 1L;
        String name = "John Doe";
        String phoneNumber = "123-456-7890";
        String emailAddress = "johndoe@example.com";
        String password = "password";
        boolean isRetailer = true;

        // act
        user.setUserId(userId);
        user.setName(name);
        user.setPhoneNumber(phoneNumber);
        user.setEmailAddress(emailAddress);
        user.setPassword(password);
        user.setRetailer(isRetailer);

        // assert
        assertEquals(userId, user.getUserId());
        assertEquals(name, user.getName());
        assertEquals(phoneNumber, user.getPhoneNumber());
        assertEquals(emailAddress, user.getEmailAddress());
        assertEquals(password, user.getPassword());
        assertEquals(isRetailer, user.getIsRetailer());
    }
}