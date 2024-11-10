package org.boot.poc.authservice.service;

import org.boot.poc.authservice.model.UserCredentials;
import org.boot.poc.authservice.repository.UserCredentialsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserCredentialsRepository userCredentialsRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private JwtService jwtService;

    public String saveUser(UserCredentials credentials){
        credentials.setPassword(encoder.encode(credentials.getPassword()));
        userCredentialsRepository.save(credentials);
        return "User Saved";
    }

    public String generateToken(String userName){
        return jwtService.generateToken(userName);
    }

    public void validateToken(String token){
         jwtService.validateToken(token);
    }
}
