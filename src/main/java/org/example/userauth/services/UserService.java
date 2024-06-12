package org.example.userauth.services;


import org.example.userauth.models.User;
import org.example.userauth.repositories.UserRepository;

public class UserService implements IUserService{
    public final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User signUp(String username, String email, String password) {

        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setHashedPassword(password);

        return userRepository.save(user);

    }

    @Override
    public User login() {
        return null;
    }
}
