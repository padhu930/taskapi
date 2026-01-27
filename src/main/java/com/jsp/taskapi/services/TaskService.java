package com.jsp.taskapi.services;

import com.jsp.taskapi.data.tasks.CreateTaskRequest;
import com.jsp.taskapi.data.tasks.Task;
import com.jsp.taskapi.data.tasks.UpdateTaskRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TaskService {
    ResponseEntity<String> createTask(CreateTaskRequest createTaskRequest);
    ResponseEntity<List<Task>> getAllTasks();
    ResponseEntity<Task> getTaskByID(Long taskId);
    ResponseEntity<String> updateTask(UpdateTaskRequest updateTaskRequest);
    ResponseEntity<String> deleteTaskByID(Long taskId);
}
