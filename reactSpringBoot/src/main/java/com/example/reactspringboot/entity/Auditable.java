package com.example.reactspringboot.entity;

import com.example.reactspringboot.domain.RequestContext;
import com.example.reactspringboot.exception.ApiException;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.util.AlternativeJdkIdGenerator;

import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt","updatedAt"},allowGetters = true)
public abstract class Auditable {
    @Id
    @SequenceGenerator(name = "primary_key_seq",sequenceName = "primary_key_seq",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "primary_key_seq")

    private Long id;
    private String referenceId=new AlternativeJdkIdGenerator().generateId().toString();
    @NotNull
    private Long createdBy;
    @NotNull
    private Long updatedBy;
    @NotNull
    @CreatedDate
    @Column(updatable = false, nullable = false)
    private LocalDateTime createdAt;
    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @PrePersist
    public void beforePersist() {
        var userId= RequestContext.getUserId();
        if (userId==null) {throw new ApiException("Cannot Persisted To the Database");
        }
        setCreatedAt(now());
        setCreatedBy(userId);
        setUpdatedBy(userId);
        setUpdatedAt(now());
    }
    @PreUpdate
    public void beforeUpdate() {
        var userId=RequestContext.getUserId();
        if (userId==null) {
            throw new ApiException("Cannot Update entity without UserID");
        }

        setUpdatedAt(now());
        setUpdatedBy(userId);
    }








}
