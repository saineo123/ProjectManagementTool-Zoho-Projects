package com.admin_auth.app.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin_auth.app.model.Admin;
import com.admin_auth.app.repository.AdminRepo;

@Service
public class AdminService {
    @Autowired
    AdminRepo admin_repo;


    public <S extends Admin> S save(final S entity){
        return admin_repo.save(entity);
    }

    // public Customer save(final Customer entity){
    //     return customerRepository.save(entity);
    // }
    
    public Optional<Admin> findName(final Long aLong){
        return admin_repo.findById(aLong);
    }

    public Iterable<Admin> findAll(){
        return admin_repo.findAll();
    }
    
    public void deleteById(final Long aLong){
        admin_repo.deleteById(aLong);
    }
}
