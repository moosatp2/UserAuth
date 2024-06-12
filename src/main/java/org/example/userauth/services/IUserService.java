package org.example.userauth.services;

import org.example.userauth.models.User;

public interface IUserService {
    User signUp(String username, String email, String password);
    User login();
}
