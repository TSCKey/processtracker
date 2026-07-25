package com.tsckey.processtracker.service;

import com.tsckey.processtracker.dtos.TaskCreationDto;
import com.tsckey.processtracker.dtos.UpdateTaskResponeDto;
import com.tsckey.processtracker.entity.Task;
import com.tsckey.processtracker.entity.enums.TaskStatus;
import com.tsckey.processtracker.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskCreationDto addTask(String taskname, String description) {
        Task task = taskRepository.findByName(taskname);
        if (task != null) throw new IllegalArgumentException("Task with such name already exists");
        task = Task.builder()
                .name(taskname)
                .description(description)
                .status(TaskStatus.offen)
                .build();
        taskRepository.save(task);

        return new TaskCreationDto(task.getName(), task.getDescription(), task.getStatus());
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public void deleteTask(String taskname) {
        Task task = taskRepository.findByName(taskname);
        taskRepository.delete(task);
    }

    public UpdateTaskResponeDto updateTaskStatus(String taskname, TaskStatus newStatus) {

        Task task = taskRepository.findByName(taskname);
        if (task == null) throw new IllegalArgumentException("Task with such name does not exist");
        task.setStatus(newStatus);
        taskRepository.save(task);
        return new UpdateTaskResponeDto(task.getName(), task.getDescription(), task.getStatus());
    }
}
