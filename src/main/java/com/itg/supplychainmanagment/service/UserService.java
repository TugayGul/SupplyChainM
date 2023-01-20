package com.itg.supplychainmanagment.service;

import com.itg.supplychainmanagment.entity.User;
import com.itg.supplychainmanagment.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User getUserById(long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User with id " + id + " not found"));
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User updateUser(long id, User user) {
        User existingUser = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User with id " + id + " not found"));
        existingUser.setName(user.getName());
        existingUser.setEmailAddress(user.getEmailAddress());
        existingUser.setPhoneNumber(user.getPhoneNumber());
        existingUser.setPassword(user.getPassword());
        existingUser.setRetailer(user.isRetailer());
        return userRepository.save(existingUser);
    }

    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }
    public class UserNotFoundException extends RuntimeException {
        public UserNotFoundException(String message) {
            super(message);
        }
    }
}