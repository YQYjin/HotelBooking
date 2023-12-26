package com.example.hotelbooking.controller;

import com.example.hotelbooking.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserControl {
    @Resource
    private UserService userService;

    @PostMapping("/registeruser")
    public String registerUser(String username, String password, String accountType) {
        String response=userService.registerUser(username,password,accountType);
        return response;
    }
    @PostMapping("/user_login")
    public String userLogin(String username, String password){
        String response=userService.userLogin(username,password);
        return response;
    }
    @PostMapping("/employee_login")
    public String staffLogin(String username, String password){
        String response=userService.userLogin(username,password);
        return response;
    }
    @PostMapping("/administrators_login")
    public String adminLogin(String username, String password){
        String response=userService.userLogin(username,password);
        return response;
    }

}
