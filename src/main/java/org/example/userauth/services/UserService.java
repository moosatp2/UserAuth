package org.example.userauth.services;


import org.example.userauth.models.Token;
import org.example.userauth.models.User;
import org.example.userauth.repositories.TokenRepository;
import org.example.userauth.repositories.UserRepository;
import org.example.userauth.utils.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService, IUserService {
    public  UserRepository userRepository;
    public  BCryptPasswordEncoder bCryptPasswordEncoder;
    public  TokenRepository tokenRepository;
    private final JwtUtil jwtUtil;
    private final EmailService emailService;
//    private final AuthenticationManager authenticationManager;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder,
                       TokenRepository tokenRepository, JwtUtil jwtUtil, EmailService emailService) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.tokenRepository = tokenRepository;
        this.jwtUtil = jwtUtil;
//        this.authenticationManager = authenticationManager;
        this.emailService = emailService;
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
    public String login(String email, String password) {

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
        return null;
        }


//        String token = jwtUtil.createToken(user);
//
//        Token newToken = new Token();
//        newToken.setUser(user);
//        newToken.setValue(token);
//
//        return tokenRepository.save(newToken);
        emailService.sendOtp(email);
        return  "OTP Send Successfully";
    }

    @Override
    public User getUser(Long id){
        return userRepository.findUserById(id);
    }

    public Token jwtGen(String email){

        User user = userRepository.findUserByEmail(email);

        String token = jwtUtil.createToken(user);

        Token newToken = new Token();
        newToken.setUser(user);
        newToken.setValue(token);

        return tokenRepository.save(newToken);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
