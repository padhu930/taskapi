package com.jsp.taskapi.data.users;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class UpdateUserMobileRequest {

    @NotBlank(message = "Mobile should not be null")
    private String oldMobile;

    @NotBlank(message = "Mobile should not be null")
    private String newMobile;

    @NotNull(message = "Mobile should not be null")
    private long userId;

    @NotBlank(message = "Password is required")
    private String password;
}
