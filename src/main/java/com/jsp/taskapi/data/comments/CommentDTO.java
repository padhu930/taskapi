package com.jsp.taskapi.data.comments;

import com.jsp.taskapi.data.users.AppUser;
import lombok.Data;

@Data
public class CommentDTO {

    private Long commentId;
    private String text;
    private String createdAt;

    private AppUser appUser;
}
