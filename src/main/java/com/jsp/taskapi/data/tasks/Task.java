package com.jsp.taskapi.data.tasks;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jsp.taskapi.data.comments.Comment;
import com.jsp.taskapi.data.users.AppUser;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.util.List;

@Data
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskId;

    @Column(name="title",nullable = false,length = 50)
    private String title;

    @Column(name="description",nullable = false,length = 100)
    private String description;


    @Column(name="status",nullable = false)
    private String status;

    @Column(name="createdAt",nullable = false)
    private String createdAt;

    @Column(name="updatedAt",nullable = false)
    private String updatedAt;

    @ManyToOne
    @JoinColumn(name = "userId")
    private AppUser appUser;

    @OneToMany
    @JsonIgnore
    private List<Comment> commentsList;


    @Override
    public String toString() {
        return "Task{" +
                "updatedAt='" + updatedAt + '\'' +
                ", taskId=" + taskId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", createdAt='" + createdAt + '\'' +
                '}';
    }
}
