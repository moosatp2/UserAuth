package org.example.userauth.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter

public class OTP extends BaseModel{
//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;
    private String email;
    private String otpHashValue;
    private LocalDateTime expiryTime;
    private boolean isVerified;
}
