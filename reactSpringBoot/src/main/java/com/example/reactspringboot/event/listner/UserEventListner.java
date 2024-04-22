package com.example.reactspringboot.event.listner;

import com.example.reactspringboot.event.UserEvent;
import com.example.reactspringboot.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserEventListner {

    private final EmailService emailService;

    @EventListener
    public void onUserEvent(UserEvent userEvent) {
        switch (userEvent.getType()){
            case REGISTRATION -> emailService.sendNewAccountEmail(userEvent.getUser().getFirstName(),userEvent.getUser().getEmail(), (String) userEvent.getData().get("key"));
            case RESETPASSWORD -> emailService.sendNewAccountEmail(userEvent.getUser().getFirstName(),userEvent.getUser().getEmail(), (String) userEvent.getData().get("key"));
            default -> {}
        }

    }
}
