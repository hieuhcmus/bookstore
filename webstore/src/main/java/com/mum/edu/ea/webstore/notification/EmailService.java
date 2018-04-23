package com.mum.edu.ea.webstore.notification;

public interface EmailService {
    void sendSimpleMessage(String to, String subject, String text);
}
