package com.jsp.taskapi.controllers;

import com.jsp.taskapi.data.tags.AssignTagToTaskResponse;
import com.jsp.taskapi.data.tasks.CreateTaskRequest;
import com.jsp.taskapi.data.tasks.Task;
import com.jsp.taskapi.data.tasks.TaskDTO;
import com.jsp.taskapi.data.users.AppUserDTO;
import com.jsp.taskapi.services.TaskService;
import com.jsp.taskapi.services.impl.TaskServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("api/v1/tasks")
public class TaskController {

    private final TaskService taskService;
    public TaskController(TaskService taskService){
        this.taskService=taskService;
    }

    @PostMapping
    ResponseEntity<Task> createTask(@RequestBody CreateTaskRequest createTaskRequest)
    {
        log.info("inside createTask {}",createTaskRequest);
        return taskService.createTask(createTaskRequest);
    }
    @GetMapping("/{taskId}")
    ResponseEntity<TaskDTO> getUserById(@PathVariable Long taskId){
        log.info("getUserById()");
        ResponseEntity<TaskDTO> response = taskService.getTaskById(taskId);
        return response;
    }

    @PostMapping("/{taskId}/tags/{tagId}")
    ResponseEntity<AssignTagToTaskResponse> assignTagToTask(@PathVariable Long taskId,
                                                            @PathVariable Long tagId){
    return taskService.addTagToTask(taskId,tagId);
    }
}
