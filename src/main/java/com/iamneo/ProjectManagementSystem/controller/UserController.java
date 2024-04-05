package com.iamneo.ProjectManagementSystem.controller;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iamneo.ProjectManagementSystem.model.User;
import com.iamneo.ProjectManagementSystem.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
   
    @Autowired
    UserService userService;
    
   @PostMapping
   @Secured("ROLE_ADMIN")
   public User saveUser(@RequestBody User user){
    return userService.save(user);
   } 

   @GetMapping
   @Secured("ROLE_ADMIN")
   //@Secured("ROLE_USER")
   public Iterable<User> getAllUsers(){
    return userService.findAll();
   }

   @GetMapping("/{id}")
   
   public Optional<User> getUserById(@PathVariable("id") Long id){
    return userService.findById(id);
   }

   @PutMapping("/{id}")
   @Secured("ROLE_ADMIN")
   public User updateUser(@PathVariable("id") Long id, @RequestBody User user){
    user.setId(id);
    return userService.save(user);
   }

   @DeleteMapping("/{id}")
   @Secured("ROLE_ADMIN")
   public void deleteUser (@PathVariable("id") Long id){
    userService.deleteById(id);
   }

   
}