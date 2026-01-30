package com.jsp.taskapi.services;

import com.jsp.taskapi.data.users.*;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AppUserService {
    ResponseEntity<CreateUserResponse> createUser(CreateUserRequest createUserRequest);
    ResponseEntity<String> updateUser();
    ResponseEntity<String> deleteUser(String email,String mobile,String password);
    ResponseEntity<List<AppUserDTO>> getAllUsers(Long userId);
    ResponseEntity<AppUserDTO> getUserById(Long userId);

    ResponseEntity<AppUserDTO> getUserByEmail(String email);
    ResponseEntity<LoginResponse> login(LoginRequest loginRequest);

    ResponseEntity<String> updateUserEmail(Long userId ,
                                           UpdateUserEmailRequest updateUserEmailRequest);
    ResponseEntity<String> updateUserName(Long userId ,
                                          UpdateUserNameRequest updateUserNameRequest);

    ResponseEntity<String> updateUserMobile(Long userId ,
                                            UpdateUserMobileRequest updateUserMobileRequest);
}
