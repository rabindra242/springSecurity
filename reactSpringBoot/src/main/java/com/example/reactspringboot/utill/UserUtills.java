package com.example.reactspringboot.utill;

import com.example.reactspringboot.entity.RoleEntity;
import com.example.reactspringboot.entity.UserEntity;
import com.fasterxml.jackson.databind.introspect.TypeResolutionContext;
import org.antlr.v4.runtime.atn.SemanticContext;

import javax.management.relation.Role;
import java.time.LocalDateTime;
import java.util.UUID;

import static org.apache.logging.log4j.util.Strings.EMPTY;


public class UserUtills {

   public static UserEntity createUserEntity(String firstName, String lastName, String email, RoleEntity role){
       return UserEntity.builder()
               .userId(UUID.randomUUID().toString())
               .firstName(firstName)
               .lastName(lastName)
               .email(email)
               .lastLoginTime(LocalDateTime.now())
               .accountNonExpired(true)
               .accountNonLocked(true)
               .enable(false)
               .loginAttempt(0)
               .qrCodeSecret(EMPTY)
               .phoneNumber(EMPTY)
               .bio(EMPTY)
               .imageUrl("https://cdn-icons-png.flaticon.com/512/21/21104.png")
               .role(role)
               .build();
   }
}
