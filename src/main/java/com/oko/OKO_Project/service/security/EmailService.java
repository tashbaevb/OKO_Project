package com.oko.OKO_Project.service.security;

public interface EmailService {
    void sendSimpleMessage(String to, String subject, String text);
}
