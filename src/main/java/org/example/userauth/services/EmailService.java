package org.example.userauth.services;

import org.example.userauth.models.OTP;
import org.example.userauth.repositories.OtpRepository;
import org.example.userauth.utils.OtpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private OtpRepository otpRepository;

    private  BCryptPasswordEncoder bCryptPasswordEncoder;

    public EmailService(BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public void sendSimpleMail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        mailSender.send(message);
    }

    public void sendOtp(String email){
        String otp = OtpUtil.generateOtp();
        OTP otpEntry = new OTP();
        otpEntry.setEmail(email);
        otpEntry.setOtpHashValue(bCryptPasswordEncoder.encode(otp));
        otpEntry.setExpiryTime(LocalDateTime.now().plusMinutes(5));
        otpEntry.setVerified(false);
        otpRepository.save(otpEntry);

        sendSimpleMail(email, "Your OTP Code", "Your OTP is: " + otp);
    }
}
