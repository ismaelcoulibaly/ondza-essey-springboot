package com.ondza.essey.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class NewsletterService {

    @Autowired
    private EmailService emailService;


    public void sendNewsletter(String to, String subject, String body) throws Exception {
        emailService.sendEmailToBooker(to, subject, body);
    }
}
