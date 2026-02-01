package com.jsp.taskapi.services.impl;

import com.jsp.taskapi.data.comments.Comment;
import com.jsp.taskapi.data.comments.CommentDTO;
import com.jsp.taskapi.data.comments.CommentRepository;
import com.jsp.taskapi.data.tasks.Task;
import com.jsp.taskapi.data.tasks.TaskDTO;
import com.jsp.taskapi.data.tasks.TaskRepository;
import com.jsp.taskapi.data.users.*;
import com.jsp.taskapi.errors.DuplicateUserException;
import com.jsp.taskapi.services.AppUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
@Service
@Slf4j
@RequiredArgsConstructor
public class AppUserServiceImpl2 implements AppUserService {

    private final AppUserRepository appUserRepository;
    private final TaskRepository taskRepository;
    private final ObjectMapper mapper;
    private final CommentRepository commentRepository;
    @Override
    public ResponseEntity<CreateUserResponse> createUser(CreateUserRequest createUserRequest) {

        boolean exists = appUserRepository.
                existsByEmailOrMobile(createUserRequest.getEmail(),createUserRequest.getMobile());

        if(exists==true){
            throw new DuplicateUserException("User with email/mobile already exists");
        }
        //Convert request to Entity
        AppUser appUser= mapper.convertValue(createUserRequest,AppUser.class);

        //Set the required values depending on requirement
        appUser.setActive(true);

        //Save the entity to the database and get the stored data
        AppUser appUserInDb = appUserRepository.save(appUser);

        //Get required values for the table
        long userId = appUserInDb.getUserId();

        //build the resp object
        CreateUserResponse response = new CreateUserResponse();
        response.setUserId(userId);
        response.setMessage("User Created");

        //return the response object with ResponseEntity
        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }

    @Override
    public ResponseEntity<String> updateUser() {
        return null;
    }

    @Override
    public ResponseEntity<String> deleteUser(String email, String mobile, String password) {
        return null;
    }

    @Override
    public ResponseEntity<List<AppUserDTO>> getAllUsers(Long userId) {
        log.info("getAllUsers()");
        //verify the user
        boolean isPresent = appUserRepository.existsById(userId);
        if(isPresent==false){
            throw new IllegalArgumentException("Security ERROR : USERID is not VALID");
        }
        //Business Logic
        //db operations(Get All Users From DB)
        List<AppUser> appUserList = appUserRepository.findAll();
        List<AppUserDTO> appUserDTOList = new ArrayList<>();

        //business logics(REMOVE PASSWORD DATA FROM RESPONSE)
        //build the response
        for(AppUser appUser :appUserList){
            AppUserDTO appUserDTO = mapper.convertValue(appUser, AppUserDTO.class);
            appUserDTOList.add(appUserDTO);
        }

        //return response
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(appUserDTOList);
    }

    @Override
    public ResponseEntity<AppUserDTO> getUserById(Long userId) {
        log.info("getUserById()");
        //find the user by userId
        AppUser appUser = appUserRepository.findById(userId).orElseThrow();
        //convert appuser to appuserDTO
        AppUserDTO response = mapper.convertValue(appUser,AppUserDTO.class);
        //find all the task of the user by userId
        List<Task> taskList = taskRepository.findByAppUserUserId(userId);
        List<TaskDTO> taskDtoList = new ArrayList<>();
        //____________________________________________________________
        List<Comment> commentList = commentRepository.findByAppUserUserId(userId);
        List<CommentDTO> commentDTOList = new ArrayList<>();

        for(Comment comment : commentList){
            CommentDTO commentDTO =  mapper.convertValue(comment,CommentDTO.class);
            commentDTOList.add(commentDTO);
        }

        //convert task to taskDTO
        for(Task task : taskList){
          TaskDTO taskDTO =  mapper.convertValue(task, TaskDTO.class);
          task.setCommentsList(commentList);
          taskDtoList.add(taskDTO);
        }
        //Set the taskDTO list

        response.setTaskList(taskDtoList);
        response.setCommentList(commentDTOList);
        response.setUserId(userId);


        //return response object
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }
    @Override
    public ResponseEntity<AppUserDTO> getUserByEmail(String email) {
        Optional<AppUser> optional = appUserRepository.findByEmail(email);
        AppUser appUser = optional.get();
        AppUserDTO appUserDTO = mapper.convertValue(appUser, AppUserDTO.class);
        log.info("appUserDTO {}",appUserDTO);
        return ResponseEntity.ok().body(appUserDTO);
    }

    @Override
    public ResponseEntity<LoginResponse> login(LoginRequest loginRequest) {
        log.info("inside login()");
        String userId;
        LoginResponse loginResponse;
        // Check if user with email and password exists in DB
        boolean isPresent  = appUserRepository.existsByEmailAndPassword
                (loginRequest.getEmail(),loginRequest.getPassword());

        if(isPresent == true){
            // Check if user with email and password exists in DB
           Optional<AppUser> userOptional =  appUserRepository.findByEmail(loginRequest.getEmail());
           AppUser appUser = userOptional.get();
           loginResponse=mapper.convertValue(appUser,LoginResponse.class);
           loginResponse.setMessage("Login Success");
//           userId=String.valueOf(appUser.getUserId());
        }
        else{
            throw new IllegalArgumentException("Invalid Email/Password");
        }
        //return userId of the given User
        return ResponseEntity.ok(loginResponse);
    }

    @Override
    public ResponseEntity<String> updateUserEmail(Long userId, UpdateUserEmailRequest updateUserEmailRequest) {
        log.info("this is updateUserEmail()");
        //Verify the User
        boolean isPresent = appUserRepository.existsById(userId);
        if(isPresent == false){
            throw new IllegalArgumentException("SECURITY ERROR : USERID is not Valid");
        }
        Optional<AppUser> appUserOptional = appUserRepository.findByEmailAndUserId(updateUserEmailRequest.getOldEmail(),
                updateUserEmailRequest.getUserId());
        if(appUserOptional.isEmpty()){
            throw new IllegalArgumentException("User with given email and userId not found");
        }
        else{
            AppUser appUser = appUserOptional.get();
            appUser.setEmail(updateUserEmailRequest.getNewEmail());
            appUserRepository.save(appUser);
        }

        return ResponseEntity.ok("User Email Updated Successfully");
    }

    @Override
    public ResponseEntity<String> updateUserName(Long userId, UpdateUserNameRequest updateUserNameRequest) {
        log.info("updateUserName()");
        //Verify User
        boolean isPresent = appUserRepository.existsById(userId);
        if(isPresent == false){
            throw new IllegalArgumentException("SECURITY ERROR : USERID is not Valid");
        }

       Optional<AppUser> appUserOptional = appUserRepository.findByNameAndUserId(updateUserNameRequest.getOldName(),
               updateUserNameRequest.getUserId());
        if(appUserOptional.isEmpty()){
                throw new IllegalArgumentException("User with given email and userId not found");
        }
        else{
            AppUser appUser = appUserOptional.get();
            appUser.setName(updateUserNameRequest.getNewName());
            appUserRepository.save(appUser);
        }
        return ResponseEntity.ok("User name updated Successfully");
    }

    @Override
    public ResponseEntity<String> updateUserMobile(Long userId,UpdateUserMobileRequest updateUserMobileRequest) {

        boolean isPresent = appUserRepository.existsById(userId);
        if(isPresent == false){
            throw new DuplicateUserException("SECURITY ERROR : USERID is not Valid");
        }
       Optional<AppUser> appUserOptional = appUserRepository.findByMobileAndPassword(updateUserMobileRequest.getOldMobile()
                ,updateUserMobileRequest.getPassword());

        if(appUserOptional.isEmpty()){
            throw new IllegalArgumentException("User with given user id and password not found");
        }
        else{
            AppUser appUser = appUserOptional.get();
            appUser.setMobile(updateUserMobileRequest.getNewMobile());
            appUserRepository.save(appUser);
        }
        return ResponseEntity.ok("User mobile is updated Successfully");

    }
}
