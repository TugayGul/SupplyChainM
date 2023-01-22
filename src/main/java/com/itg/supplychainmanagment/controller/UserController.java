package com.itg.supplychainmanagment.controller;

import com.itg.supplychainmanagment.entity.User;
import com.itg.supplychainmanagment.repository.UserRepository;
import com.itg.supplychainmanagment.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;

    public UserController(UserService userService,
                          UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }


    @PostMapping("/login")
    public String login(@RequestParam String emailAddress, @RequestParam String password) {
        User user = userRepository.findByEmailAddressAndPassword(emailAddress, password);
        if (user == null || !user.getPassword().equals(password)) {
            throw new IllegalArgumentException("Invalid email or password");
        }
        if (user.getIsRetailer()){
            return "Hoşgeldiniz retailer"; // TODO: change this to redirect retailer page
        }
        else{
        return "hoşgeldiniz supplier"; // TODO: change this to redirect supplier page
     }
    }
}