package com.iamneo.ProjectManagementSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iamneo.ProjectManagementSystem.model.Project;
import com.iamneo.ProjectManagementSystem.repository.ProjectRepository;

import java.util.List;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    // Method to retrieve projects assigned to a team member
    public List<Project> getProjectsAssignedTo(String assignedTo) {
        return projectRepository.findByAssignedTo(assignedTo);
    }

    // Method to create a new project
    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    // Method to retrieve all projects
    public Iterable<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    // Method to update an existing project
    public Project updateProject(Long projectId, Project updatedProject) {
        Project existingProject = projectRepository.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Project not found with id: " + projectId));

        existingProject.setName(updatedProject.getName());
        existingProject.setAssignedTo(updatedProject.getAssignedTo());
        // Add more fields to update as needed

        return projectRepository.save(existingProject);
    }
}
