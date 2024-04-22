package com.example.reactspringboot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

import static jakarta.persistence.FetchType.EAGER;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "user")
public class UserEntity extends Auditable {
    @Column(unique = true, updatable = false, nullable = false)
    private String userId;
    private String firstName;
    private String lastName;
    @Column(unique = true, nullable = false)
    private String email;
    private Integer loginAttempt;
    private LocalDateTime lastLoginTime;
    private String phoneNumber;
    private String bio;
    private String imageUrl;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean enable;
    @JsonIgnore
    private boolean mfa;
    private String qrCodeSecret;
    @Column(columnDefinition = "text")
    private String qrCodeImageUri;
    @ManyToOne(fetch = EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(
                    name = "user_id",
                    referencedColumnName = "id"
            ), inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
    private RoleEntity role;


}
