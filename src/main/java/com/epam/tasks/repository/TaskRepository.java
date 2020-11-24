package com.epam.tasks.repository;

import com.epam.tasks.model.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {

    // Example of custom search query
    Task findByTitle(String title);

    List<Task> findAllByEnabled(boolean isEnabled);

    List<Task> findAllByEnabledOrderByPriorityAsc(boolean isEnabled);

    void deleteByTitle(String title);

}
