package org.example.userauth.dtos;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailRequestDto {
    private String to;
    private String subject;
    private String body;
}
