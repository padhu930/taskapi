package com.jsp.taskapi.data.comments;

import com.jsp.taskapi.data.users.AppUser;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CommentRequest {

    @NotBlank(message = "Empty comment doesnot allowed")
    private String text;

    private Long userId;

}
