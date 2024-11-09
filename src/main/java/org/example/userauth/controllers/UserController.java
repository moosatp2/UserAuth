package org.example.userauth.controllers;


import org.example.userauth.dtos.LoginRequestDto;
import org.example.userauth.dtos.LoginResponseDto;
import org.example.userauth.dtos.SignUpRequestDto;
import org.example.userauth.dtos.UserResponseDto;
import org.example.userauth.models.Token;
import org.example.userauth.models.User;
import org.example.userauth.services.UserService;
import org.example.userauth.utils.JwtUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    public UserService userService;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    public UserController(UserService userService, JwtUtil jwtUtil, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/signup")
    private User signUp(@RequestBody SignUpRequestDto signUpRequestDto) {

        String username = signUpRequestDto.getUsername();
        String email = signUpRequestDto.getEmail();
        String password = signUpRequestDto.getPassword();

        User user = userService.signUp(username, email, password);
        return user;
    }
    @PostMapping("/login")
    private LoginResponseDto login(@RequestBody LoginRequestDto loginRequestDto) {

        String email = loginRequestDto.getEmail();
        String password = loginRequestDto.getPassword();

        Token token = userService.login(email, password);

        LoginResponseDto loginResponseDto = new LoginResponseDto();
        loginResponseDto.setValue(token.getValue());
        loginResponseDto.setUsername(token.getUser().getEmail());

        return loginResponseDto;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getUserById(@PathVariable Long id) {

        User user = new User();
        user = userService.getUser(id);
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setId(user.getId());
        userResponseDto.setEmail(user.getEmail());
        userResponseDto.setUsername(user.getUsername());
        ResponseEntity<UserResponseDto> responseEntity =  new ResponseEntity<>(userResponseDto, HttpStatus.OK);
        return responseEntity;
    }
}
