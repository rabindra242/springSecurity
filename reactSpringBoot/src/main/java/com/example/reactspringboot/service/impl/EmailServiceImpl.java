package com.example.reactspringboot.service.impl;

import com.example.reactspringboot.exception.ApiException;
import com.example.reactspringboot.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import static com.example.reactspringboot.utill.EmailUtill.getEmailMessage;
import static com.example.reactspringboot.utill.EmailUtill.getResetPasswordMessage;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailServiceImpl implements EmailService {

    private static final String NEW_USER_VERIFICATION = "New User Verification";
    private static final String PASSWORD_RESERT ="Password Resert"; ;
    private final JavaMailSender sender;
    @Value("${spring.mail.host}")
    private String host;
    @Value("${spring.mail.username}")
    private String fromEmail;

    @Override
    @Async
    public void sendNewAccountEmail(String to, String name, String token) {
        
        try {
            var message = new SimpleMailMessage();
            message.setSubject(NEW_USER_VERIFICATION);
            message.setTo(to);
            message.setText(getEmailMessage(name,host,token));
        }catch (Exception e){
            log.info(e.getMessage());
            throw new ApiException("Emal not reeding");
        }

    }

    @Override
    @Async
    public void sendPasswordResetEmail(String to, String name, String token) {

        try {
            var message = new SimpleMailMessage();
            message.setSubject(PASSWORD_RESERT);
            message.setTo(to);
            message.setText(getResetPasswordMessage(name,host,token));
        }catch (Exception e){
            log.info(e.getMessage());
            throw new ApiException("Emal not reeding");
        }

    }
}
