package org.boot.poc.authservice.service;

import org.boot.poc.authservice.model.CustomUserDetails;
import org.boot.poc.authservice.model.UserCredentials;
import org.boot.poc.authservice.repository.UserCredentialsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    public UserCredentialsRepository repository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserCredentials> cres = Optional.of(repository.findByUserName(username).orElseThrow());
        return cres.map(CustomUserDetails::new).orElseThrow();
    }
}
