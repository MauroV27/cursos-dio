package com.learn.tasks.services;

import com.learn.tasks.domain.model.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {

    Task create(Task taskToCreate);
    Optional<Task> findById(Long id);
    List<Task> getTasks();
    void deleteTaskById(Long id);
    Task updateTask(Task task);

//    Optional<Task> changeState(Long id);
}

