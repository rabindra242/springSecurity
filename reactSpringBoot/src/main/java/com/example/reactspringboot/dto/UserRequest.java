package com.example.reactspringboot.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserRequest {
    @NotEmpty(message = "FirstName Cannot be Empty")
    private String firstName;
    @NotEmpty(message = "lastName Cannot be Empty or Null")
    private String lastName;
    @NotEmpty(message = "Email Cannot be Empty")
    @Email(message = "Invalid Email Address")
    private String email;
    @NotEmpty(message = "Password Cannot be Empty")

    private String password;
    private String bio;
    private String phone;


}
