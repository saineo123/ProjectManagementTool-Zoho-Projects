// package com.example.PractiseProject.controller;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import com.example.PractiseProject.model.Task;
// import com.example.PractiseProject.service.TaskService;

// import java.util.List;
// import java.util.Optional;

// @RestController
// @RequestMapping("/tasks")
// public class TaskController {

//     @Autowired
//     private TaskService taskService;

//     // Create task
//     @PostMapping
//     public ResponseEntity<Task> createTask(@RequestBody Task task) {
//         Task createdTask = taskService.createTask(task);
//         return ResponseEntity.status(HttpStatus.CREATED).body(createdTask);
//     }

//     // Read all tasks
//     @GetMapping
//     public ResponseEntity<List<Task>> getAllTasks() {
//         List<Task> tasks = taskService.getAllTasks();
//         return ResponseEntity.ok(tasks);
//     }

//     // Read task by ID
//     @GetMapping("/{id}")
//     public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
//         Optional<Task> task = taskService.getTaskById(id);
//         return task.map(ResponseEntity::ok)
//                 .orElseGet(() -> ResponseEntity.notFound().build());
//     }

//     // Update task
//     @PutMapping("/{id}")
//     public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task updatedTask) {
//         updatedTask.setId(id);
//         Task task = taskService.updateTask(updatedTask);
//         return ResponseEntity.ok(task);
//     }

//     // Delete task
//     @DeleteMapping("/{id}")
//     public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
//         taskService.deleteTask(id);
//         return ResponseEntity.noContent().build();
//     }
// }

package com.example.PractiseProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.PractiseProject.model.Task;
import com.example.PractiseProject.service.TaskService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    // Create task
    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        Task createdTask = taskService.createTask(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTask);
    }

    // Read all tasks
    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> tasks = taskService.getAllTasks();
        return ResponseEntity.ok(tasks);
    }

    // Read task by ID
    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        Optional<Task> task = taskService.getTaskById(id);
        return task.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update task
    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task updatedTask) {
        updatedTask.setId(id);
        Task task = taskService.updateTask(updatedTask);
        return ResponseEntity.ok(task);
    }

    // Delete task
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}
