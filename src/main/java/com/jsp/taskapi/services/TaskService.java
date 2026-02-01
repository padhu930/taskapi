package com.jsp.taskapi.services;

import com.jsp.taskapi.data.comments.CommentDTO;
import com.jsp.taskapi.data.tasks.CreateTaskRequest;
import com.jsp.taskapi.data.tasks.Task;
import com.jsp.taskapi.data.tasks.TaskDTO;
import com.jsp.taskapi.data.tasks.UpdateTaskRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TaskService {
    ResponseEntity<Task> createTask(CreateTaskRequest createTaskRequest);
    ResponseEntity<List<Task>> getAllTasks();
    ResponseEntity<TaskDTO> getTaskById(Long taskId);
    ResponseEntity<String> updateTask(UpdateTaskRequest updateTaskRequest);
    ResponseEntity<String> deleteTaskByID(Long taskId);
}
