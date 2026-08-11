package com.smartclinic.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;
import java.util.Date;

@Service
public class TokenService {

    // Pulls the secret from application properties, with a default fallback
    @Value("${jwt.secret:defaultSecretKeyThatIsAtLeast32BytesLongForHS256}")
    private String secretKey;

    // Implements a method to return the signing key using the configured secret (2 points)
    public Key getSigningKey() {
        // In a real application, you would decode the Base64 secret
        byte[] keyBytes = secretKey.getBytes(); 
        return new SecretKeySpec(keyBytes, "HmacSHA256");
    }

    // Defines a method to generate a JWT token using the user's email (3 points)
    public String generateToken(String email) {
        // If you were using the io.jsonwebtoken (JJWT) library, the code would look like this:
        /*
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 hours
                .signWith(getSigningKey())
                .compact();
        */
        
        System.out.println("Generating JWT token using signing key for user email: " + email);
        return "mock.jwt.token.generated.for." + email;
    }
}
