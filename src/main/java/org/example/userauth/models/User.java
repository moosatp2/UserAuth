package org.example.userauth.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class User extends BaseModel {
    private String username;
    private String hashedPassword;
    private String email;
}
