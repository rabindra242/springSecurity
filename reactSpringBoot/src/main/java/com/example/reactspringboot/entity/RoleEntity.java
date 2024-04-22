package com.example.reactspringboot.entity;

import com.example.reactspringboot.enumaration.Authority;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "roles")
public class RoleEntity extends Auditable  {
    private String name;
    private Authority authorities;
}
