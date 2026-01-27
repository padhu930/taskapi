package com.jsp.taskapi.data.users;

import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String password;
}
