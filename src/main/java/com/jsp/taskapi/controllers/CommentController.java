package com.jsp.taskapi.controllers;

import com.jsp.taskapi.data.comments.CommentRequest;
import com.jsp.taskapi.data.comments.CommentResponse;
//import com.jsp.taskapi.services.impl.CommentServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/api/tasks/{taskId}/comments")
public class CommentController {

//    private final CommentServiceImpl commentService;

//    @Autowired
//    public CommentController(CommentServiceImpl commentService) {
//        this.commentService = commentService;
//    }

//    @PostMapping()
//    public ResponseEntity<CommentResponse> addComment(@RequestBody @Valid CommentRequest commentRequest){
//        log.info("inside addComment() commentRequest:{}",commentRequest);
//
//        ResponseEntity<CommentResponse> response =   commentService.addComment(commentRequest);
//
//        return response;
//    }


}
