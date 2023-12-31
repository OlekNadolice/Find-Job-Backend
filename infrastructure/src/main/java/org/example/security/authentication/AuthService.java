package org.example.security.authentication;


import org.example.entities.user.CustomUser;
import org.example.repositories.user.UserCommandRepository;
import org.example.security.jwt.InvalidCredentialsException;
import org.example.security.jwt.JwtService;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;




@Service
public class AuthService {


    private final JwtService jwtService;

    private final UserCommandRepository userCommandRepository;

    private  final PasswordEncoder passwordEncoder;




    private final AuthenticationManager authenticationManager;


    public AuthService(JwtService jwtService, UserCommandRepository userCommandRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager) {
        this.jwtService = jwtService;
        this.userCommandRepository = userCommandRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
    }

    public String loginUser(LoginUserDTO data) {

        Authentication authenticationToken = new UsernamePasswordAuthenticationToken(data.emailAddress(), data.password());
        try {
            Authentication authentication = authenticationManager.authenticate(authenticationToken);
            UserDetails user = (UserDetails) authentication.getPrincipal();
            return this.jwtService.generateJwtToken(user.getUsername(), user.getAuthorities().stream().map(Object::toString).toList());
        } catch (AuthenticationException e) {
            throw new InvalidCredentialsException("Login credentials are not valid");
        }

    }


    public CustomUser registerUser(RegisterUserDTO data) {
        CustomUser user = new CustomUser();
        String password = passwordEncoder.encode(data.getPassword().value());
        user.setEmailAddress(data.getEmailAddress());
        user.setFirstName(data.getFirstName());
        user.setLastName(data.getLastName());
        user.setPassword(data.getPassword());
        this.userCommandRepository.save(user);
        return user;

    }


}
