package com.jsp.taskapi.services.impl;

import com.jsp.taskapi.data.tasks.CreateTaskRequest;
import com.jsp.taskapi.data.tasks.Task;
import com.jsp.taskapi.data.tasks.UpdateTaskRequest;
import com.jsp.taskapi.services.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    @Override
    public ResponseEntity<String> createTask(CreateTaskRequest createTaskRequest) {
        return null;
    }

    @Override
    public ResponseEntity<List<Task>> getAllTasks() {
        return null;
    }

    @Override
    public ResponseEntity<Task> getTaskByID(Long taskId) {
        return null;
    }

    @Override
    public ResponseEntity<String> updateTask(UpdateTaskRequest updateTaskRequest) {
        return null;
    }

    @Override
    public ResponseEntity<String> deleteTaskByID(Long taskId) {
        return null;
    }
}
