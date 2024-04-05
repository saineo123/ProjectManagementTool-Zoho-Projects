package com.iamneo.ProjectManagementSystem.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
 
@Entity
@Data
@NoArgsConstructor

public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String Email;
    private String password;
 
 
}