package com.jsp.taskapi.services;

import com.jsp.taskapi.data.comments.CommentRequest;
import com.jsp.taskapi.data.comments.CommentResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface CommentService {
    ResponseEntity<CommentResponse> addComment(CommentRequest commentRequest);
}
