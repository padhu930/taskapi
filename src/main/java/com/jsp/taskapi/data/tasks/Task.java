package com.jsp.taskapi.data.tasks;

import com.jsp.taskapi.data.tasks.util.TaskStatus;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;
import org.hibernate.annotations.CreationTimestamp;

@Data
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long taskId;
    @Column(name="title",nullable = false,length = 50)
    private String title;
    @Column(name="description",nullable = false,length = 100)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name="status")
    private TaskStatus status;

    @CreationTimestamp
    private String createdAt;
    private String updatedAt;
}
