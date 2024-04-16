package com.admin_auth.app.controller;

import java.time.LocalDate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.temporal.ChronoUnit;
import com.admin_auth.app.model.Projects;
import com.admin_auth.app.services.ProjectService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/auth/projects")
public class ProjectsController {
    @Autowired
    private ProjectService projectService;

    @GetMapping
    @Secured("ROLE_ADMIN")
    public ResponseEntity<List<Projects>> getAllProjects(){
        List<Projects> projects = projectService.getAllProjects();
        return ResponseEntity.ok(projects);
    }

    @DeleteMapping("/{projectId}")
    @Secured("ROLE_ADMIN")
    public ResponseEntity<?> deleteProject(@PathVariable Long projectId){
        projectService.deleteProject(projectId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{projectId}/progress")
    @Secured("ROLE_ADMIN")
    public ResponseEntity<?> getProjectProgress(@PathVariable Long projectId) {
        Projects project = projectService.getProjectById(projectId);
        if (project == null) {
            return ResponseEntity.notFound().build();
        }
    
        // Convert Date to LocalDate
        LocalDate localStartDate = project.getStartDate().toLocalDate();
        LocalDate localEndDate = project.getEndDate().toLocalDate();
    
        // Calculate the duration between the two dates
        long totalDays = ChronoUnit.DAYS.between(localStartDate, localEndDate);
    
        // Calculate progress (for demonstration, assuming progress is 0%)
        String progress = totalDays+" days";
    
        return ResponseEntity.ok(progress);
    }


}
