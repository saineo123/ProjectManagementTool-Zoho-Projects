package com.iamneo.ProjectManagementSystem.repository;

import com.iamneo.ProjectManagementSystem.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

// UserRepository interface for performing CRUD operations on User entities
public interface UserRepository extends JpaRepository<User, Long> {

    // Find a user by their username
    Optional<User> findByUsername(String username);

    // Find a user by their email address
    Optional<User> findByEmail(String email);
}
