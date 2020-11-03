package com.epam.tasks.runner;

import com.epam.tasks.model.Task;
import com.epam.tasks.repository.TaskRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class MyRunner implements CommandLineRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyRunner.class);

    @Autowired
    private TaskRepository taskRepository;

    @Override
    @Transactional
    public void run(String... args) {

        LOGGER.info("initializing tasks");

        Task articleTask = new Task("Finish article", "Finish the article and send for review", true, 0);
        taskRepository.save(articleTask);

        Task speechTask = new Task("Meeting speech", "Prepare the speech for the meeting", false, 2);
        taskRepository.save(speechTask);

        Task drTask = new Task("Call dr Robbins", "Cancel the visit", true, 1);
        taskRepository.save(drTask);

        Task bookingTask = new Task("Book a hotel", "Book a hotel for vacation", true, 4);
        taskRepository.save(bookingTask);
    }
}
