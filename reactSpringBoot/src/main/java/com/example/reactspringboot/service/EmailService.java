package com.example.reactspringboot.service;

public interface EmailService {
    void sendNewAccountEmail(String to,String name,String token);
    void sendPasswordResetEmail(String to,String name,String token);

}
