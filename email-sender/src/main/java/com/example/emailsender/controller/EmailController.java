package com.example.emailsender.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.emailsender.resource.EmailMessage;
import com.example.emailsender.service.EmailSenderService;

@RestController
public class EmailController {

    private final EmailSenderService emailSenderService;
    
    public EmailController(EmailSenderService emailSenderService) {
        this.emailSenderService = emailSenderService;
    }

    @PostMapping("/email-send")
    public ResponseEntity<String> sendEmail(@RequestBody EmailMessage emailMessage){
        this.emailSenderService.sendEmail(emailMessage.getTo(),emailMessage.getSubject(), emailMessage.getMessage());
        return ResponseEntity.ok("sucess");
    }
}
