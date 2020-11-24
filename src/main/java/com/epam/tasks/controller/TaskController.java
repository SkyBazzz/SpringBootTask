package com.epam.tasks.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.epam.tasks.dto.TaskDTO;
import com.epam.tasks.model.Task;
import com.epam.tasks.service.TaskService;

@RestController
@Validated
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/tasks/{id}")
    public Task findById(@PathVariable Long id) {
        return taskService.findById(id);
    }

    @GetMapping("/task/{title}")
    public Task findByTitle(@PathVariable String title) {
        return taskService.findByTitle(title);
    }

    @GetMapping("/tasks")
    public List<Task> allUsers() {
        return taskService.findAll();
    }

    @GetMapping("/tasks/count")
    public Long count() {
        return taskService.count();
    }

    @PostMapping("/task")
    public ResponseEntity<String> save(@Valid @RequestBody TaskDTO taskDto) {
        Task task = new Task();
        task.setId(taskDto.getId());
        task.setTitle(taskDto.getTitle());
        task.setSummary(taskDto.getSummary());
        task.setEnabled(taskDto.isEnabled());
        task.setPriority(taskDto.getPriority());
        taskService.save(task);
        return ResponseEntity.ok("Task info is valid.");
    }

    @PutMapping("/tasks/{id}")
    public ResponseEntity<Object> updateById(@PathVariable Long id, @Valid @RequestBody TaskDTO taskDto) {
        Task task = new Task();
        task.setId(id);
        task.setTitle(taskDto.getTitle());
        task.setSummary(taskDto.getSummary());
        task.setEnabled(taskDto.isEnabled());
        task.setPriority(taskDto.getPriority());
        taskService.save(task);
        return ResponseEntity.noContent()
                             .build();
    }

    @DeleteMapping("/tasks/{id}")
    public void delete(@PathVariable String id) {
        Long userId = Long.parseLong(id);
        taskService.deleteById(userId);
    }
}