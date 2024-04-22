package com.example.reactspringboot.service;

import com.example.reactspringboot.entity.RoleEntity;
import com.example.reactspringboot.enumaration.Authority;

public interface UserService {

    void createUser(String firstName, String lastName,String Email,String password);

    RoleEntity getRoleName(String name);
}
