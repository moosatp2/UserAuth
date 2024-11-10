package org.example.userauth.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OtpRequestDto {
    private String email;
    private String otp;
}
