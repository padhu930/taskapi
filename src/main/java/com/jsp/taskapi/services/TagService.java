package com.jsp.taskapi.services;

import com.jsp.taskapi.data.tags.CreateTagRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface TagService {
    ResponseEntity<String> addTag(CreateTagRequest createTagRequest);
}
