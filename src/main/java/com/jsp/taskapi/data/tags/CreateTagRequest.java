package com.jsp.taskapi.data.tags;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateTagRequest {
    @NotBlank(message = "TagName should not be blank")
    private String tagName;
}
