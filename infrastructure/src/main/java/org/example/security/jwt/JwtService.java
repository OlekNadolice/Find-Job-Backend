package org.example.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class JwtService {


    @Value("${spring.jwt.secret}")
    private String jwtSecret;


    @Value("${spring.jwt.expiration}")
    private Long jwtExpiration;

    public String generateJwtToken(String username, List<String> roles) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + this.jwtExpiration * 1000);
        Map<String, Object> claims = new HashMap<>();
        claims.put("roles", roles);
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, this.jwtSecret)
                .compact();
    }

    public String extractTokenFromHeader(String token) {
        return token.split(" ")[1].trim();
    }


    public boolean isJwtInHeaderAndStartsWithBearer(String token) {
        return token != null && token.startsWith("Bearer");
    }


    public boolean validateJwt(String token) {
        try {
            Jwts.parser().setSigningKey(this.jwtSecret).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String extractUsernameFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(this.jwtSecret)
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }
}
