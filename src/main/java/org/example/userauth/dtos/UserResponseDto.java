package org.example.userauth.dtos;

import lombok.Getter;
import lombok.Setter;
import org.example.userauth.models.BaseModel;

@Getter
@Setter
public class UserResponseDto extends BaseModel {
    private String username;
    private String email;
}
