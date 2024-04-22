package com.example.reactspringboot.repo;

import com.example.reactspringboot.entity.Confirmation;
import com.example.reactspringboot.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ConfirmationRepository extends JpaRepository<Confirmation, Long> {

    Optional<Confirmation> findByKey(String key);
    Optional<Confirmation> findByUserEntity(UserEntity userEntity);

}
