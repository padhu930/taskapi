package com.jsp.taskapi.data.tasks;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.jsp.taskapi.data.comments.Comment;
import com.jsp.taskapi.data.tags.Tags;
import com.jsp.taskapi.data.users.AppUser;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Generated;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@ToString(exclude = {"appUser","commentList","tags"})
@EqualsAndHashCode(onlyExplicitlyIncluded = true) //dont add equals and hashcode
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

    @OneToMany(mappedBy = "task",cascade = CascadeType.ALL,orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Comment> commentsList;

    @ManyToMany
    @JoinTable(name = "task_tag_ids",
               joinColumns = @JoinColumn(name = "taskId"),
               inverseJoinColumns = @JoinColumn(name = "tagId"))
    private Set<Tags> tags = new HashSet<>();


//    @Override
//    public String toString() {
//        return "Task{" +
//                "updatedAt='" + updatedAt + '\'' +
//                ", taskId=" + taskId +
//                ", title='" + title + '\'' +
//                ", description='" + description + '\'' +
//                ", status='" + status + '\'' +
//                ", createdAt='" + createdAt + '\'' +
//                '}';
//    }

}
