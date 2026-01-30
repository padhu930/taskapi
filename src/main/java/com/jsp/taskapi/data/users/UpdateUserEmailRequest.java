package com.jsp.taskapi.data.users;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateUserEmailRequest {

    @NotBlank(message = "new email cannot be empty/null")
    private String newEmail;

    @NotBlank(message = "old email cannot be empty/null")
    private String oldEmail;

    @NotNull(message = "user Id is required")
    private Long userId;
}
