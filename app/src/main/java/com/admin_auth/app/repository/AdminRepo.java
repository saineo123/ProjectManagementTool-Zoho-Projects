package com.admin_auth.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.admin_auth.app.model.Admin;

@Repository
public interface AdminRepo extends JpaRepository<Admin,Long>{
    
}
