package com.itg.supplychainmanagment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/register")
    public String register() {
        return "register";
    }


    @RequestMapping("/customlogin")
    public String login() {
        return "customlogin";
    }


    @RequestMapping("/home")
    public String home() {
        return "home";
    }
}
