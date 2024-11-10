package org.boot.poc.authservice.controller;

import org.boot.poc.authservice.model.UserCredentials;
import org.boot.poc.authservice.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService service;

    @Autowired
    private AuthenticationManager manager;

    @PostMapping("/register")
    public String addUser(@RequestBody UserCredentials user){
        return service.saveUser(user);
    }

    @PostMapping("/token")
    public String getToken(@RequestBody UserCredentials user){
        Authentication auth = manager.authenticate(new UsernamePasswordAuthenticationToken(user.getUserName(),user.getPassword()));
        if(auth.isAuthenticated())
            return service.generateToken(user.getUserName());

        throw new UsernameNotFoundException(user.getUserName());
    }

    @GetMapping("/validate")
    public String validateToken(@RequestParam("token") String  token){
         service.validateToken(token);
         return "Validated";
    }
}
