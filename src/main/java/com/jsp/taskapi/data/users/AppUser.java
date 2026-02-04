package com.jsp.taskapi.data.users;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.jsp.taskapi.data.comments.Comment;
import com.jsp.taskapi.data.tasks.Task;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@Entity
@ToString(exclude = {"taskList","commentList"})
@Table(name = "appusers")
public class AppUser {
    @Id
    @Column(name = "userid",nullable = false,unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY) //mysql create and manages id
    private Long userId;

    @Column(name = "name",nullable = false,length = 20)
    private String name;

    @Column(name = "email",nullable = false,unique = true ,length = 40)
    private String email;

    @Column(name = "mobile",nullable = false ,unique = true,length = 10)
    private String mobile;

    @Column(name = "password",nullable = false,length = 20)
    private String password;

    @Column(name = "isActive",nullable = false)
    private boolean isActive;

    @OneToMany(mappedBy = "appUser",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Task> taskList;

    @OneToMany(mappedBy = "appUser", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Comment> commentList;

}
