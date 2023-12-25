package com.example.hotelbooking.controller;

import com.example.hotelbooking.service.EmailService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class EmailControl {
    @Resource
    private EmailService emailService;

    @PostMapping("/updateemail")
    public String updateEmail(String username,String newEmail){
        String response=emailService.updateEmail(username,newEmail);
        return response;
    }
}
