package com.example.reactspringboot.controller;


import com.example.reactspringboot.domain.Response;
import com.example.reactspringboot.dto.UserRequest;
import com.example.reactspringboot.service.UserService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

import static com.example.reactspringboot.utill.RequestUtill.getResponse;
import static java.util.Collections.emptyMap;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserResource {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<Response> saveUser(@RequestBody @Valid UserRequest userRequest, HttpServletRequest request){
        userService.createUser(userRequest.getFirstName(),userRequest.getLastName(),userRequest.getEmail(),userRequest.getPassword());
        return ResponseEntity.created(getUri()).body(getResponse(request,emptyMap(),"Accpunt Created.Check Your Email", HttpStatus.CREATED));

    }

    private URI getUri() {
        return URI.create("");
    }
}
