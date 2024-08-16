package com.semicolon.africa.models;

<<<<<<< HEAD
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private boolean isLoggedIn;

    @DBRef
    List<User> users;

=======
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.List;

@Getter
@Setter
public class User {

    @Id
    private String id;
    private String email;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String password;
    private boolean isLoggedIn;
>>>>>>> 185de8656f14c1cda4289fd348d607e1d261c4e4
}
