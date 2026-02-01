package com.jsp.taskapi.data.tasks;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class CreateTaskRequest {
    private String title;
    private String description;
    @Length(max=10)
    private String status;
    private Long userId;
}
