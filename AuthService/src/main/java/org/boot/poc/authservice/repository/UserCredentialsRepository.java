package org.boot.poc.authservice.repository;

import org.boot.poc.authservice.model.UserCredentials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserCredentialsRepository extends JpaRepository<UserCredentials,Long> {
    Optional<UserCredentials> findByUserName(String name);
}
