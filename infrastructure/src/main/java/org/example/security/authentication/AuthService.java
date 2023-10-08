package org.example.security.authentication;


import org.example.entities.user.CustomUser;
import org.example.repositories.user.UserCommandRepository;
import org.example.repositories.user.UserQueryRepository;
import org.example.security.jwt.InvalidCredentialsException;
import org.example.security.jwt.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.Optional;


@Service
public class AuthService {


    private final JwtService jwtService;

    private final UserCommandRepository userCommandRepository;

    private final UserQueryRepository userQueryRepository;


    private final AuthenticationManager authenticationManager;


    public AuthService(JwtService jwtService, UserCommandRepository userCommandRepository, UserQueryRepository userQueryRepository, AuthenticationManager authenticationManager) {
        this.jwtService = jwtService;
        this.userCommandRepository = userCommandRepository;
        this.userQueryRepository = userQueryRepository;
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
        Optional<CustomUser> isUserExists = userQueryRepository.findById(data.getId());
        if(isUserExists.isPresent()) {
            throw new RuntimeException();
        }
        CustomUser user = new CustomUser();
        user.setId(data.getId());
        user.setEmailAddress(data.getEmailAddress());
        user.setFirstName(data.getFirstName());
        user.setLastName(data.getLastName());
        user.setPassword(data.getPassword());
        this.userCommandRepository.save(user);
        return user;

    }


}
