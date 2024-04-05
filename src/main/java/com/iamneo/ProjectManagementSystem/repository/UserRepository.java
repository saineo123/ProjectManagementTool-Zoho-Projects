package com.iamneo.ProjectManagementSystem.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.iamneo.ProjectManagementSystem.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long>{
} 

