package com.example.reactspringboot.entity;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.UUID;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@Entity
@Table(name = "confirmations")
public class Confirmation extends Auditable{
    @Column(name = "confirmation_key")
    private String key;
    @OneToOne(targetEntity = UserEntity.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    @JsonProperty("user_id")
    private UserEntity userEntity;

    public Confirmation(String key, UserEntity userEntity) {
        this.key = UUID.randomUUID().toString();
        this.userEntity = userEntity;
    }
}
