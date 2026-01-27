package com.jsp.taskapi.data.users;

import lombok.Data;

@Data
public class LoginResponse {
    private long userId;
    private String name;
    private String message;
}
