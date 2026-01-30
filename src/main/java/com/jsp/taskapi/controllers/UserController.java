package com.jsp.taskapi.controllers;

import com.jsp.taskapi.data.users.*;
import com.jsp.taskapi.services.AppUserService;
import com.jsp.taskapi.services.impl.AppUserServiceImpl2;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@Slf4j
public class UserController {
    //immutable

    private  AppUserServiceImpl2 appUserService;
    @Autowired
    public UserController(AppUserServiceImpl2 appUserService)
    {
        this.appUserService = appUserService;
    }

    @PostMapping
    public ResponseEntity<CreateUserResponse> addUser(@RequestBody @Valid CreateUserRequest createUserRequest)
    {
        log.info("inside addUser() createUserRequest : {}",createUserRequest);
        ResponseEntity<CreateUserResponse> response = appUserService.createUser(createUserRequest);
        log.info("inside addUser() : User created");
        return response;
    }

    @PatchMapping("/email")
    public ResponseEntity<String> updateUserEmail(@RequestHeader Long userId,
                                             @RequestBody @Valid UpdateUserEmailRequest updateUserEmailRequest){
        log.info("updateUserEmail()");
        ResponseEntity<String> response = appUserService.updateUserEmail(userId,updateUserEmailRequest);

        return response;
    }


    @DeleteMapping
    ResponseEntity<String> deleteUser(String email,String mobile,String password){
        System.out.println("this is UserController --> deleteUser()");
        ResponseEntity<String> response = appUserService.deleteUser(email,mobile,password);
        return response;
    }

    @GetMapping
    ResponseEntity<List<AppUserDTO>> getAllUsers(@RequestHeader Long userId){

        log.info("getAllUsers()");
        log.info("userId {}",userId);
        ResponseEntity<List<AppUserDTO>> response = appUserService.getAllUsers(userId);
        return response;
    }
    @GetMapping("/{userId}")
    ResponseEntity<AppUserDTO> getUserById(@PathVariable Long userId){
        log.info("getUserById()");
        ResponseEntity<AppUserDTO> response = appUserService.getUserById(userId);
        return response;
    }

    @GetMapping("/email/{email}")
    ResponseEntity<AppUserDTO> getUserByEmail(@PathVariable String email){
        log.info("getUserByEmail()");
        ResponseEntity<AppUserDTO> response = appUserService.getUserByEmail(email);
        return response;
    }
    @PostMapping("/login")
    ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest){
        log.info("login()");
        ResponseEntity<LoginResponse> response = appUserService.login(loginRequest);
        return response;
    }

    @PatchMapping("/name")
    ResponseEntity<String> updateUserName(@RequestHeader Long userId ,
                                        @RequestBody @Valid  UpdateUserNameRequest updateUserNameRequest){
        log.info("updateUserName()");
        ResponseEntity<String> response = appUserService.updateUserName(userId,updateUserNameRequest);
        return response;
    }


    @PatchMapping("/mobile")
    ResponseEntity<String> updateUserMobile(@RequestHeader Long userId ,
                                          @RequestBody @Valid  UpdateUserMobileRequest updateUserMobileRequest){
        log.info("updateUserMobile()");
        ResponseEntity<String> response = appUserService.updateUserMobile(userId,updateUserMobileRequest);
        return response;
    }

}
