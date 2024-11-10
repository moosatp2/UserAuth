package org.example.userauth.controllers;

import org.example.userauth.dtos.EmailRequestDto;
import org.example.userauth.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/email")
public class EmailController {
    @Autowired
    private EmailService emailService;

    @PostMapping("/send")
    public String sendEmail(@RequestBody EmailRequestDto emailRequestDto) {

        String to =  emailRequestDto.getTo();
        String subject = emailRequestDto.getSubject();
        String body = emailRequestDto.getBody();
        emailService.sendSimpleMail(to, subject, body);

        return "Email sent successfully!";
    }
}
