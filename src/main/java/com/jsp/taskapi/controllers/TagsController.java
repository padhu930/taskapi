package com.jsp.taskapi.controllers;

import com.jsp.taskapi.data.tags.CreateTagRequest;
import com.jsp.taskapi.services.impl.TagServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/tags")
@RequiredArgsConstructor
public class TagsController {

    private final TagServiceImpl tagService;

    @PostMapping
    ResponseEntity<String> createNewTag(@RequestBody @Valid CreateTagRequest createTagRequest){
       return tagService.addTag(createTagRequest);
    }
}
