package com.jsp.taskapi.services.impl;

import com.jsp.taskapi.data.tags.CreateTagRequest;
import com.jsp.taskapi.data.tags.Tags;
import com.jsp.taskapi.data.tags.TagsRepository;
import com.jsp.taskapi.services.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {

    private final TagsRepository tagsRepository;
    private final ObjectMapper mapper;
    @Override
    public ResponseEntity<String> addTag(CreateTagRequest createTagRequest) {
        //Business Logic
        Tags tag = mapper.convertValue(createTagRequest, Tags.class);
        tagsRepository.save(tag);
        return ResponseEntity.ok("Tag Created");
    }
}
