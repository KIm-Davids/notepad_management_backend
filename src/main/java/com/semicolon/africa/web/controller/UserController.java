package com.semicolon.africa.web.controller;

import com.semicolon.africa.dtos.request.LogOutUserRequest;
import com.semicolon.africa.dtos.request.LoginUserRequest;
import com.semicolon.africa.dtos.request.RegisterUserRequest;
import com.semicolon.africa.dtos.response.ApiResponse;
import com.semicolon.africa.dtos.response.LogOutResponse;
import com.semicolon.africa.dtos.response.LoginUserResponse;
import com.semicolon.africa.dtos.response.RegisterUserResponse;
import com.semicolon.africa.services.UserServicesImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/login/notepad")
@RequiredArgsConstructor
public class UserController {

    private UserServicesImpl services;

    @PostMapping("/register-user/")
    public ResponseEntity<?> registerUser(@RequestBody RegisterUserRequest request) {
        try {
            RegisterUserResponse response = services.register(request);
            return new ResponseEntity<>(new ApiResponse(true, response), OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(new ApiResponse(false, exception), BAD_REQUEST);
        }
    }

    @PatchMapping("/login-user")
    public ResponseEntity<?> loginUser(@RequestBody LoginUserRequest request) {
        try {
            LoginUserResponse response = services.login(request);
            return new ResponseEntity<>(new ApiResponse(true, response), OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(new ApiResponse(false, exception), BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<?> logOutUser(@RequestBody LogOutUserRequest request){
        try{
            LogOutResponse response = services.logout(request);
            return new ResponseEntity<>(new ApiResponse(true, response),OK);
        }catch(Exception exception){
            return new ResponseEntity<>(new ApiResponse(false,exception), BAD_REQUEST);
        }
    }
}
