package com.jsp.taskapi.data.comments;

import com.jsp.taskapi.data.users.AppUser;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CommentDTO {

    private Long commentId;
    private String text;
    private LocalDate createdAt;
    private String status;
//    private AppUser appUser;
}
