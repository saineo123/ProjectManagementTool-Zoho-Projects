package com.admin_auth.app.services;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.admin_auth.app.model.Projects;
import com.admin_auth.app.repository.ProjectRepo;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepo project_repo;

    /// ---------------------------------------------------
    Set<Projects> set = new HashSet<>();

    public List<Projects> getAllProjects(){
        return project_repo.findAll();
    }

    @Secured("ROLE_ADMIN")
    public void deleteProject(Long projectId) {
        project_repo.deleteById(projectId);
    } 

    @Secured("ROLE_ADMIN")
    public Projects getProjectById(Long projectId){
        Optional<Projects> projectOptional = project_repo.findById(projectId);
        return projectOptional.orElse(null);
    }

    @Secured("ROLE_ADMIN")
    public Projects saveProjects(Projects projects){
        return project_repo.save(projects);
    }

    // @Secured("ROLE_ADMIN")
    // public Projects saveProjects(Projects projects) {
    //     // Check if a project with the same title, start date, end date, and description exists
    //     Projects existingProject = (Projects) project_repo.findAll();

    //     // If a duplicate project is found, you can handle it accordingly
    //     if (existingProject != null) {
    //         // For example, you can throw an exception, log a message, or return null
    //         // Here, we'll throw an exception
    //         //throw new DuplicateProjectException("Project with the same title, start date, end date, and description already exists");
    //         System.out.println("Project already exists");
    //     }

    //     // If no duplicate project is found, save the new project
    //     return project_repo.save(projects);
    // }
    
    
}
