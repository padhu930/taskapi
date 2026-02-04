package com.jsp.taskapi.controllers;

import com.jsp.taskapi.data.comments.Comment;
import com.jsp.taskapi.data.comments.CommentRequest;
import com.jsp.taskapi.data.comments.CommentResponse;
//import com.jsp.taskapi.services.impl.CommentServiceImpl;
import com.jsp.taskapi.services.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("/api/v1/comments")
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public ResponseEntity<Comment> addComment(@RequestBody CommentRequest commentRequest){
        log.info("inside addComment() commentRequest:{}",commentRequest);

        ResponseEntity<Comment> response =   commentService.addComment(commentRequest);

        return response;
    }

    @GetMapping
    ResponseEntity<String> getComments(@PathVariable Long userId,@PathVariable Long taskId)
    {
        return null;
    }

}
