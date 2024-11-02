package org.example.userauth.dtos;


import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.example.userauth.models.User;

import java.util.Date;

@Getter
@Setter
public class LoginResponseDto {

    private String value;
    private String username;
    private Date expireAt;
}
