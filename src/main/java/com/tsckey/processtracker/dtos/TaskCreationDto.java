package com.tsckey.processtracker.dtos;

import com.tsckey.processtracker.entity.enums.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TaskCreationDto {

    private String taskname;
    private String description;
    private TaskStatus status;
}
