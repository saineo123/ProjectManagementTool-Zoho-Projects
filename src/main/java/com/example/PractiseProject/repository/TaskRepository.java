package com.example.PractiseProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.PractiseProject.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    // You can add custom query methods here if needed
}
