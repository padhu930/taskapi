package com.jsp.taskapi.data.comments;

import com.jsp.taskapi.data.users.AppUser;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CommentRequest {

    @NotBlank(message = "Empty comment doesnot allowed")
    private String text;

    @NotBlank(message = "Mention the status first...")
    private String status;

    @NotBlank(message = "UserId is mandatory")
    private Long userId;
}
