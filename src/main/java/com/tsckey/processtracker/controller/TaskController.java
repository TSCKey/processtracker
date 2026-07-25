package com.tsckey.processtracker.controller;

import com.tsckey.processtracker.dtos.TaskCreationDto;
import com.tsckey.processtracker.dtos.UpdateTaskResponeDto;
import com.tsckey.processtracker.entity.Task;
import com.tsckey.processtracker.entity.enums.TaskStatus;
import com.tsckey.processtracker.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;


    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        return ResponseEntity.ok(taskService.getAllTasks());
    }

    @PatchMapping("/{taskname}")
    public ResponseEntity<UpdateTaskResponeDto> updateTask(@PathVariable("taskname") String taskname,
                                                           @RequestBody TaskStatus newStatus){

        return ResponseEntity.ok(taskService.updateTaskStatus(taskname, newStatus));
    }

    @PostMapping("/create-task")
    public ResponseEntity<TaskCreationDto> addTask(@RequestBody TaskCreationDto dto){
        return ResponseEntity.ok(taskService.addTask(dto.getTaskname(), dto.getDescription()));
    }

    @DeleteMapping("/{taskname}")
    public ResponseEntity<Void> deleteTask(@PathVariable String taskname){
        taskService.deleteTask(taskname);
        return ResponseEntity.noContent().build();
    }
}
