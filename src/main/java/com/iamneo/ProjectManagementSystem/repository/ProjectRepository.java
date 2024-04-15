package com.iamneo.ProjectManagementSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iamneo.ProjectManagementSystem.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findByAssignedTo(String assignedTo);
}
