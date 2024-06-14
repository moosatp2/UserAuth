package org.example.userauth.services;


import org.example.userauth.models.Token;
import org.example.userauth.models.User;
import org.example.userauth.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{
    public  UserRepository userRepository;
    public  BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public User signUp(String username, String email, String password) {

        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setHashedPassword(bCryptPasswordEncoder.encode(password));

        User user1 = userRepository.save(user);
        return user1;
    }

    @Override
    public Token login(String email, String password) {

        //check user existing or not
        User user = userRepository.findUserByEmailAndAndHashedPassword(email, password);
        //check password is matching with hashed pass using bcrypt
        //if matching create token and return
        return null;
    }
}
