package com.tsckey.processtracker.dtos;

import com.tsckey.processtracker.entity.enums.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdateTaskResponeDto {
    private String taskname;
    private String Description;
    private TaskStatus newStatus;
}
