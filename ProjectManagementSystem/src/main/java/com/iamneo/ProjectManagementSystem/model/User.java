package com.iamneo.ProjectManagementSystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data // Lombok annotation to generate getters, setters, toString, and hashCode methods
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Username should not be blank and should be between 4 and 20 characters long
    @NotBlank
    @Size(min = 4, max = 20)
    private String username;

    // Email should not be blank and should match the specified pattern for a valid email address
    @NotBlank
    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "Please provide a valid email address")
    private String email;

    // Password should not be blank and should match the specified pattern for a strong password
    @NotBlank
    @Pattern(regexp = "^(?=.*[A-Z].*[a-zA-Z]*)(?=.*[0-9].*[0-9].*[0-9].*[0-9])(?=.*[@#$%^&+=!]).{9,16}$\r\n", 
        message = "Password must contain at least 4 alphabets with one in uppercase, 4 numerical values, and at least one special character")
    private String password;
}
