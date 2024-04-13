package com.iamneo.ProjectManagementSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iamneo.ProjectManagementSystem.model.Task;
import com.iamneo.ProjectManagementSystem.repository.TaskRepository;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public Task markTaskAsClosed(Long id) {
        Task task = taskRepository.findById(id).orElse(null);
        if (task != null) {
            task.setClosed(true);
            return taskRepository.save(task);
        }
        return null;
    }
}
