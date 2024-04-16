package com.admin_auth.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.admin_auth.app.model.Projects;
import com.admin_auth.app.repository.ProjectRepo;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepo project_repo;

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
    
}
