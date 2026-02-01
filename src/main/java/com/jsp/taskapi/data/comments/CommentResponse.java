package com.jsp.taskapi.data.comments;

import com.jsp.taskapi.data.users.AppUser;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class CommentResponse {

    private Long commentId;
    private String text;
}
