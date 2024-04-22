package com.example.reactspringboot.repo;

import com.example.reactspringboot.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByEmailIgnoreCase(String email);
    Optional<UserEntity> findUserEntitiesByUserId(String userId);
}
