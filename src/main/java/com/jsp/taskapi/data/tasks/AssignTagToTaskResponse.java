package com.jsp.taskapi.data.tasks;

import com.jsp.taskapi.data.tags.Tags;
import lombok.Data;

import java.util.Set;

@Data
public class AssignTagToTaskResponse {
    private Long taskId;
    private String title;
    private Set<Tags> tags;
}
