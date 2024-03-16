package com.goutam.backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return  "Enter username and pass for login";
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return  "Login success";
    }
}
