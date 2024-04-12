package com.iamneo.ProjectManagementSystem.service;

import com.iamneo.ProjectManagementSystem.model.User;
import com.iamneo.ProjectManagementSystem.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Service method to register a new user
    @Transactional
    public User registerUser(User user) throws Exception {
        // Check if the username already exists
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new Exception("Username already exists");
        }
        // Check if the email already exists
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new Exception("Email already exists");
        }
        // Save the user to the database
        return userRepository.save(user);
    }
}
