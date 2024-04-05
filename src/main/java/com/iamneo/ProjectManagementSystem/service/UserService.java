package com.iamneo.ProjectManagementSystem.service;

import com.iamneo.ProjectManagementSystem.model.User;
import com.iamneo.ProjectManagementSystem.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserService {
    @Autowired
    UserRepository userRepository;

    public <S extends User> S save(final S entity){
        return userRepository.save(entity);
    }

    public Optional<User> findById(final Long id){
        return userRepository.findById(id);
    }

    public Iterable<User> findAll(){
        return userRepository.findAll();
    }
    
    public void deleteById(final Long id){
        userRepository.deleteById(id);
    }
}
