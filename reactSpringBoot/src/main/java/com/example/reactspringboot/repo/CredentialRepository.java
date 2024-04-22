package com.example.reactspringboot.repo;

import com.example.reactspringboot.entity.CredentialEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CredentialRepository extends JpaRepository<CredentialEntity, Long> {

    Optional<CredentialEntity> getCredntialByUserEntityId(Long id);
}
