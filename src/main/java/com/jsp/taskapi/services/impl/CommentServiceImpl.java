//package com.jsp.taskapi.services.impl;
//
//import com.jsp.taskapi.data.comments.Comment;
//import com.jsp.taskapi.data.comments.CommentRepository;
//import com.jsp.taskapi.data.comments.CommentRequest;
//import com.jsp.taskapi.data.comments.CommentResponse;
//import com.jsp.taskapi.data.users.AppUser;
//import com.jsp.taskapi.data.users.AppUserRepository;
//import com.jsp.taskapi.services.CommentService;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import tools.jackson.databind.ObjectMapper;
//
//import java.util.Optional;
//
//@Service
//@Slf4j
//@RequiredArgsConstructor
//public class CommentServiceImpl implements CommentService {
//
//    @Autowired
//    private final CommentRepository commentRepository;
//    private final AppUserRepository appUserRepository;
//    private final ObjectMapper mapper;
//
//    @Override
//    public ResponseEntity<CommentResponse> addComment(CommentRequest commentRequest) {
//
//        log.info("inside addComment() : {}",commentRequest);
//
//        appUserRepository.findById(commentRequest.getUserId()).orElseThrow();
//
//        //convert comment request to Entity
//        Comment comment = mapper.convertValue(commentRequest, Comment.class);
//        Comment commentInDb = commentRepository.save();
//        Long commentId = commentInDb.getCommentId();
//
//        CommentResponse commentResponse = new CommentResponse();
//        commentResponse.setCommentId(commentId);
//        commentResponse.setText("Comment Added successfully");
//
//
//        return ResponseEntity.status(HttpStatus.CREATED).body(commentResponse);
//    }
//}
