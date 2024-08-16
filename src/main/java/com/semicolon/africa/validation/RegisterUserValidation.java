package com.semicolon.africa.validation;

import com.semicolon.africa.dtos.request.RegisterUserRequest;
import com.semicolon.africa.exception.WrongInputFormat;

public class RegisterUserValidation {

    public static void validateEmail(RegisterUserRequest request) {
        if (!request.getEmail().contains("@gmail.com") || request.getEmail().contains("@email.com")) throw new WrongInputFormat("Please Input a valid email");
    }

}
