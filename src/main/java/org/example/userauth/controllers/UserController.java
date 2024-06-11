package org.example.userauth.controllers;

import org.example.userauth.models.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping("/signup")
    private User signUp(){
        return null;
    }
    @PostMapping("/login")
    private User login(){
        return null;
    }
}
