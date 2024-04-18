package com.example.PractiseProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PractiseProject.model.Task;
import com.example.PractiseProject.repository.TaskRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    // Create operations

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    // Read operations

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    // Update operations

    public Task updateTask(Task updatedTask) {
        return taskRepository.save(updatedTask);
    }

    // Delete operations

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
