package com.iamneo.ProjectManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iamneo.ProjectManagementSystem.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}

