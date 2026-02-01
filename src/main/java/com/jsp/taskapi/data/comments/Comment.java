package com.jsp.taskapi.data.comments;

import com.jsp.taskapi.data.tasks.Task;
import com.jsp.taskapi.data.users.AppUser;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@ToString(exclude = "appUser")
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="commentId",nullable = false,unique = true)
    private Long commentId;

    @Column(name="text", nullable = false)
    private String text;

    @ManyToOne
    @JoinColumn(name = "task_Id")
    private AppUser appUser;

}
