package com.jsp.taskapi.data.users;

import com.jsp.taskapi.data.tasks.Task;
import com.jsp.taskapi.data.tasks.TaskDTO;
import lombok.Data;

import java.util.List;

@Data
public class AppUserDTO {
    private Long userId;
    private String name;
    private String email;
    private String mobile;
    private boolean isActive;

    private List<TaskDTO> taskList;
}
