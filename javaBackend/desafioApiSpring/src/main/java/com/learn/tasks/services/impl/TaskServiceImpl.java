package com.learn.tasks.services.impl;

import com.learn.tasks.domain.model.Task;
import com.learn.tasks.domain.repository.TaskRepository;
import com.learn.tasks.services.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task create(Task taskToCreate) {
        return this.taskRepository.save(taskToCreate);
    }

    @Override
    public Optional<Task> findById(Long id) {
        return this.taskRepository.findById(id);
    }

    @Override
    public List<Task> getTasks() {
        return this.taskRepository.findAll();
    }

    @Override
    public void deleteTaskById(Long id) {
        this.taskRepository.deleteById(id);
    }

    @Override
    public Task updateTask(Task task) {
        return this.taskRepository.save(task);
    }

//    @Override
//    public Optional<Task> changeState(Long id) {
//        taskRepository.updateStatusById(id);
//        return this.taskRepository.findById(id);
//    }
}
