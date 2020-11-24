package com.epam.tasks.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.tasks.model.Task;
import com.epam.tasks.repository.TaskRepository;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task findById(Long id) {
        return taskRepository.findById(id)
                             .orElseThrow(RuntimeException::new);
    }

    public Task findByTitle(String title) {
        return taskRepository.findByTitle(title);
    }

    public Task save(Task task) {
       return taskRepository.save(task);
    }

    public List<Task> findAll() {
        Iterable<Task> allTasks = taskRepository.findAll();
        ArrayList<Task> tasks = new ArrayList<>();
        allTasks.forEach(tasks::add);

        return tasks;
    }

    public Long count() {
        return taskRepository.count();
    }

    public void deleteById(Long userId) {
        taskRepository.deleteById(userId);
    }
}
