package com.semicolon.africa.services;

import com.semicolon.africa.dtos.request.LogOutUserRequest;
import com.semicolon.africa.dtos.request.LoginUserRequest;
import com.semicolon.africa.dtos.request.RegisterUserRequest;
import com.semicolon.africa.dtos.response.LoginUserResponse;
import com.semicolon.africa.dtos.response.LogoutResponse;
import com.semicolon.africa.dtos.response.RegisterUserResponse;
import com.semicolon.africa.models.User;

import java.util.List;

public interface UserServices {

    RegisterUserResponse registerUserWith(RegisterUserRequest request);
    List<User> getAllUsers();
    LoginUserResponse login(LoginUserRequest request);
    LogoutResponse logoutResponse(LogOutUserRequest request);

}
