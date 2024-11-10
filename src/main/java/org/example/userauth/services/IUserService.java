package org.example.userauth.services;

import org.example.userauth.models.Token;
import org.example.userauth.models.User;

public interface IUserService {
    User signUp(String username, String email, String password);
    String login(String email, String password);
    User getUser(Long id);
}
