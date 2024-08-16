package com.semicolon.africa.services;

import com.semicolon.africa.dtos.request.LogOutUserRequest;
import com.semicolon.africa.dtos.request.LoginUserRequest;
import com.semicolon.africa.dtos.request.RegisterUserRequest;
import com.semicolon.africa.dtos.response.LoginUserResponse;
import com.semicolon.africa.dtos.response.LogoutResponse;
import com.semicolon.africa.dtos.response.RegisterUserResponse;
import com.semicolon.africa.exception.UserNotFoundException;
import com.semicolon.africa.exception.WrongPasswordException;
import com.semicolon.africa.models.User;
import com.semicolon.africa.repository.UserRepository;
import org.springframework.stereotype.Service;

import static com.semicolon.africa.validation.RegisterUserValidation.validateEmail;

@Service
public class UserServicesImpl {

    private final UserRepository repository;

    public UserServicesImpl(UserRepository repository) {
        this.repository = repository;
    }

    public RegisterUserResponse register(RegisterUserRequest request) {
        RegisterUserResponse response = new RegisterUserResponse();
        User user = new User();
        validateEmail(request);
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        repository.save(user);
        response.setMessage("Registered Successfully");
        return response;
    }

    public LoginUserResponse login(LoginUserRequest request){
        LoginUserResponse response = new LoginUserResponse();
        validateUser(request);
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setLoggedIn(true);
        response.setMessage("Logged In");
        return response;
    }

    public LogoutResponse logout(LogOutUserRequest request){
        LogoutResponse response = new LogoutResponse();
        User user = findUserByEmail(request);
        user.setLoggedIn(false);
        repository.save(user);
        response.setMessage("Logged out successfully");
        return response;

    }

    private void validateUser(LoginUserRequest request){
        User user = repository.findByEmail(request.getEmail()).orElseThrow(() -> new UserNotFoundException("User Not Found"));
        if(!user.getPassword().equals(request.getPassword())) throw new WrongPasswordException("Incorrect Password");
    }

    private User findUserByEmail(LogOutUserRequest request){
        return repository.findByEmail(request.getEmail()).orElseThrow(() -> new UserNotFoundException("User Not Found"));
    }

}
