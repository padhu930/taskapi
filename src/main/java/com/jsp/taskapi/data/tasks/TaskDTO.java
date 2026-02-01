package com.jsp.taskapi.data.tasks;

import com.jsp.taskapi.data.comments.CommentDTO;
import jakarta.persistence.Column;
import lombok.Data;

import java.util.List;

@Data
public class TaskDTO {

    private Long taskId;

    private String title;

    private String description;

    private String status;

    private String createdAt;

    private String updatedAt;

    private List<CommentDTO> commentList;
}
