package com.learn.tasks.controllers;

import com.learn.tasks.domain.model.Task;
import com.learn.tasks.services.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Task>> findById(@PathVariable Long id){
        var task = taskService.findById(id);
        return ResponseEntity.ok(task);
    }

    @GetMapping("")
    public ResponseEntity<List<Task>> getTasks(){
        return ResponseEntity.ok(taskService.getTasks());
    }

    @PostMapping
    public ResponseEntity<Task> create(Task taskToCreate){
        var userCreated = taskService.create(taskToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userCreated.getId())
                .toUri();
        return ResponseEntity.created(location).body(userCreated);
    }

    @PutMapping
    public ResponseEntity<Task> update(Task task){
        var updatedTask = taskService.updateTask(task);
        return ResponseEntity.ok(updatedTask);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        taskService.deleteTaskById(id);
        return ResponseEntity.ok("Task deleted");
    }

//    @PostMapping("/status/{id}")
//    public ResponseEntity<Optional<Task>> updateStatusById(@PathVariable Long id){
//        var taskStatusUpdated = taskService.changeState(id);
//        return ResponseEntity.ok(taskStatusUpdated);
//    }

}
