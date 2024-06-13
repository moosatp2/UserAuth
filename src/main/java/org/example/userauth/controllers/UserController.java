package org.example.userauth.controllers;

import org.example.userauth.dtos.SignUpRequestDto;
import org.example.userauth.models.User;
import org.example.userauth.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    public UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    private User signUp(@RequestBody SignUpRequestDto signUpRequestDto) {

        String username = signUpRequestDto.getUsername();
        String email = signUpRequestDto.getEmail();
        String password = signUpRequestDto.getPassword();

        User user = userService.signUp(username, email, password);
        return user;
    }
    @PostMapping("/login")
    private User login(){
        return null;
    }
}
