package org.example.security.authentication;


import org.example.security.jwt.InvalidCredentialsException;
import org.example.security.jwt.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;



@Service
public class AuthService {



    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    public AuthService( JwtService jwtService, AuthenticationManager authenticationManager) {
        this.jwtService = jwtService;
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


}
