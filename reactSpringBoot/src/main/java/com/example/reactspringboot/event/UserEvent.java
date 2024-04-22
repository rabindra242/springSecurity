package com.example.reactspringboot.event;

import com.example.reactspringboot.entity.UserEntity;
import com.example.reactspringboot.enumaration.EventType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class UserEvent {
    private UserEntity user;
    private EventType type;
    private Map<?,?> data;
}
