package com.epam.tasks.controller.fakecontrollers;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@Validated
public class SpecialAgentController {

    private static final String NOT_FOUND_MESSAGE = "Agent was not found";
    public List<SpecialAgent> agents = new ArrayList<>();

    @PostMapping("/agent")
    public ResponseEntity<String> validate(@Valid @RequestBody SpecialAgent agent) {
        agents.add(agent);
        return ResponseEntity.ok("Agent info is valid.");
    }

    @GetMapping("/agent/{id}")
    public SpecialAgent getAgent(@PathVariable int id) {
        return agents.get(id);
    }

    @ExceptionHandler(IndexOutOfBoundsException.class)
    public HashMap<String, String> handleIndexOutOfBoundsException(Exception e) {
        HashMap<String, String> response = new HashMap<>();
        response.put("message", NOT_FOUND_MESSAGE);
        response.put("error", e.getClass().getSimpleName());
        return response;
    }
}
