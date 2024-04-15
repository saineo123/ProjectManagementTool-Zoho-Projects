package com.iamneo.ProjectManagementSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.iamneo.ProjectManagementSystem.model.Project;
import com.iamneo.ProjectManagementSystem.service.ProjectService;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    // Endpoint to retrieve projects assigned to a team member
    @GetMapping("/{assignedTo}")
    public ResponseEntity<List<Project>> getProjectsAssignedTo(@PathVariable String assignedTo) {
        List<Project> projects = projectService.getProjectsAssignedTo(assignedTo);
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }

    // Endpoint to retrieve all projects
    @GetMapping
    public ResponseEntity<Iterable<Project>> getAllProjects() {
        Iterable<Project> projects = projectService.getAllProjects();
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }

    // Endpoint to create a new project
    @PostMapping
    public ResponseEntity<Project> createProject(@RequestBody Project project) {
        Project createdProject = projectService.createProject(project);
        return new ResponseEntity<>(createdProject, HttpStatus.CREATED);
    }

    // Endpoint to update an existing project
    @PutMapping("/{projectId}")
    public ResponseEntity<Project> updateProject(@PathVariable Long projectId, @RequestBody Project updatedProject) {
        Project updated = projectService.updateProject(projectId, updatedProject);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }
}
