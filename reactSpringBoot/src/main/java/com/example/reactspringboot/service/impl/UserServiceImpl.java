package com.example.reactspringboot.service.impl;

import com.example.reactspringboot.entity.Confirmation;
import com.example.reactspringboot.entity.CredentialEntity;
import com.example.reactspringboot.entity.RoleEntity;
import com.example.reactspringboot.entity.UserEntity;
import com.example.reactspringboot.enumaration.Authority;
import com.example.reactspringboot.enumaration.EventType;
import com.example.reactspringboot.event.UserEvent;
import com.example.reactspringboot.exception.ApiException;
import com.example.reactspringboot.repo.ConfirmationRepository;
import com.example.reactspringboot.repo.CredentialRepository;
import com.example.reactspringboot.repo.RoleRepository;
import com.example.reactspringboot.repo.UserRepository;
import com.example.reactspringboot.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.Map;

import static com.example.reactspringboot.utill.UserUtills.createUserEntity;

@Service
@Transactional(rollbackOn = Exception.class)
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final CredentialRepository credentialRepository;
    private final ConfirmationRepository confirmationRepository;
    //    private final BcryptPasswordEncoder encoder;
    private final ApplicationEventPublisher publisher;


    @Override
    public void createUser(String firstName, String lastName, String email, String password) {
    var userEntity=userRepository.save(createNewUser(firstName,lastName,email));
    var credentialEntity= new CredentialEntity(password,userEntity);
    credentialRepository.save(credentialEntity);
    var confirmation=new Confirmation(userEntity);
    confirmationRepository.save(confirmation);
    publisher.publishEvent(new UserEvent(userEntity, EventType.REGISTRATION, Map.of("key",confirmation.getKey())));
    }

    @Override
    public RoleEntity getRoleName(String name) {
        var role=roleRepository.findByNameIgnoreCase(name);

        return role.orElseThrow(()->new ApiException("Role Not Found"));
    }

    private UserEntity createNewUser(String firstName, String lastName, String email) {
        var role=getRoleName(Authority.USER.name());
        return createUserEntity(firstName,lastName,email,role);
    }
}
