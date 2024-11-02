package org.example.userauth.services;


import org.example.userauth.models.Token;
import org.example.userauth.models.User;
import org.example.userauth.repositories.TokenRepository;
import org.example.userauth.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;

@Service
public class UserService implements IUserService{
    public  UserRepository userRepository;
    public  BCryptPasswordEncoder bCryptPasswordEncoder;
    public  TokenRepository tokenRepository;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder,
                       TokenRepository tokenRepository) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.tokenRepository = tokenRepository;
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
        User user = userRepository.findUserByEmail(email);

        if (user == null){
            System.out.println("user not exist with email " + email);
            return null;
        }

        //check password is matching with hashed pass using bcrypt
        boolean passwordMatch = BCrypt.checkpw(password, user.getHashedPassword());

        if(!passwordMatch) {
            System.out.println("incorrect password");
//            return null;
        }
        //if matching create token and return

        String tokenData = user.getEmail() + ":" + new Date().getTime();
        String tokenValue = Base64.getEncoder().encodeToString(tokenData.getBytes(StandardCharsets.UTF_8));

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR, 24);
        Date expireAt = calendar.getTime();

        Token newToken = new Token();
        newToken.setUser(user);
        newToken.setValue(tokenValue);
        newToken.setExpireAt(expireAt);

        return tokenRepository.save(newToken);

    }
}
