package com.jsp.taskapi.services.impl;

import com.jsp.taskapi.data.users.*;
import com.jsp.taskapi.errors.DuplicateUserException;
import com.jsp.taskapi.services.AppUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Optional;
@Service
@Slf4j
@RequiredArgsConstructor
public class AppUserServiceImpl2 implements AppUserService {

    private final AppUserRepository appUserRepository;
    private final ObjectMapper mapper;
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
        //verify the user
        boolean isPresent = appUserRepository.existsById(userId);
        if(isPresent==false){
            throw new IllegalArgumentException("Security ERROR : USERID is not VALID");
        }
        //Business Logic
        return null;
    }

    @Override
    public ResponseEntity<AppUserDTO> getUserById(Long userId) {
        log.info("getUserById()");
        //perform db operations(GET USER FROM DB)
//        AppUser appUser = userDb.get(userId);

        Optional<AppUser> optional = appUserRepository.findById(userId);
        AppUser appUser = optional.get();
        AppUserDTO response = mapper.convertValue(appUser,AppUserDTO.class);
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
}
