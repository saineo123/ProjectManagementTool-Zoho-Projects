package com.admin_auth.app.controller;

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

import com.admin_auth.app.model.Admin;
import com.admin_auth.app.services.AdminService;

@RestController
@RequestMapping("/auth")
public class AdminController {
    @Autowired
    AdminService admin_service;

    @PostMapping
    @Secured("ROLE_ADMIN")
    public Admin saveCustomer(@RequestBody Admin admin){
        return admin_service.save(admin);
    }

    @GetMapping
    public Iterable<Admin> getAllCustomers(){
        return admin_service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Admin> getCustomerById(@PathVariable("AdminId") Long id){
        return admin_service.findName(id);
    }

    @PutMapping("/{id}")
    @Secured("ROLE_ADMIN")
    public Admin updateCustomer(@PathVariable("AdminId") Long id, @RequestBody Admin admin){
        admin.setAdminId(id);
        return admin_service.save(admin);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer (@PathVariable("id") Long id){
        admin_service.deleteById(id);
    }
    
}
