package com.jsp.taskapi.data.users;

import com.jsp.taskapi.data.comments.CommentDTO;
import com.jsp.taskapi.data.tasks.Task;
import com.jsp.taskapi.data.tasks.TaskDTO;
import lombok.Data;

import javax.xml.stream.events.Comment;
import java.util.List;

@Data
public class AppUserDTO {
    private Long userId;
    private String name;
    private String email;
    private String mobile;
    private boolean isActive;

    private List<TaskDTO> taskList;

    private List<CommentDTO> commentList;
}
