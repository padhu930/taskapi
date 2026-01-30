package com.jsp.taskapi.data.users;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateUserNameRequest {

    @NotBlank(message = "Name Should not be Null / empty")
    private String oldName;

    @NotBlank(message = "Name Should not be Null / empty")
    private String newName;

    @NotNull(message = "User Id Should not be Null")
    private Long userId;
}
