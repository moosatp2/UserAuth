package org.example.userauth.services;

import org.apache.catalina.User;

public interface IUserService {
    User signUp();
    User login();
}
