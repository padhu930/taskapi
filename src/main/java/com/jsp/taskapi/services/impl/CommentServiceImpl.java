package com.jsp.taskapi.services.impl;

import com.jsp.taskapi.data.comments.Comment;
import com.jsp.taskapi.data.comments.CommentRepository;
import com.jsp.taskapi.data.comments.CommentRequest;
import com.jsp.taskapi.data.comments.CommentResponse;
import com.jsp.taskapi.data.tasks.Task;
import com.jsp.taskapi.data.tasks.TaskRepository;
import com.jsp.taskapi.data.users.AppUser;
import com.jsp.taskapi.data.users.AppUserRepository;
import com.jsp.taskapi.services.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.time.LocalDate;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    @Autowired
    private final CommentRepository commentRepository;
    private final AppUserRepository appUserRepository;
    private final TaskRepository taskRepository;
    private final ObjectMapper mapper;

    @Override
    public ResponseEntity<Comment> addComment(CommentRequest commentRequest) {

        log.info("inside addComment() : {}",commentRequest);

       Task task = taskRepository.findById(commentRequest.getUserId()).orElseThrow();

        AppUser appUser = appUserRepository.findById(commentRequest.getUserId())
                .orElseThrow();

        //convert commentRequest to Comment Entity
        Comment comment = mapper.convertValue(commentRequest, Comment.class);

        //set created Date
        comment.setCreatedAt(LocalDate.now());
        comment.setText("Added create operation");
        comment.setTask(task);
        comment.setAppUser(appUser);
//        comment.setTask(task);

        //save the comment to DB
        Comment savedComment = commentRepository.save(comment);

        log.info("saved {} ",savedComment);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedComment);
    }
}
