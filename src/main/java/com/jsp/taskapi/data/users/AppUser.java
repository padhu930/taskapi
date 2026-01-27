package com.jsp.taskapi.data.users;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
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
}
