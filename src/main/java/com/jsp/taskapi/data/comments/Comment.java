package com.jsp.taskapi.data.comments;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.jsp.taskapi.data.tasks.Task;
import com.jsp.taskapi.data.users.AppUser;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;

@Data
@Entity
@ToString(exclude = {"task","appUser"})
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="commentId",nullable = false,unique = true)
    private Long commentId;

    @Column(name="text", nullable = false)
    private String text;

    @Column(name="createdAt" , nullable = false)
    private LocalDate createdAt;

    @Column(name="status",nullable = false)
    private String status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private AppUser appUser;

    @ManyToOne
    @JoinColumn(name = "task_id")
    @JsonBackReference
    private Task task;



}
