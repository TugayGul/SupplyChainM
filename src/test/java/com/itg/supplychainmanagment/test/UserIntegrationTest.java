package com.itg.supplychainmanagment.test;


import com.itg.supplychainmanagment.entity.User;
import com.itg.supplychainmanagment.repository.UserRepository;
import com.itg.supplychainmanagment.service.UserService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
@Transactional
public class UserIntegrationTest {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Test
    public void testCreateUser(){
        User user = new User();
        user.setName("John");
        user.setEmailAddress("john@example.com");
        user.setPassword("password");
        user.setPhoneNumber("1234567890");
        user = userService.createUser(user);
        assertNotNull(user);
        assertNotNull(user.getUserId());
    }
}