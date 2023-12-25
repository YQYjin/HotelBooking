package com.example.hotelbooking.controller;

import org.springframework.web.bind.annotation.PostMapping;

public class UserControl {

    @PostMapping("/registeruser")
    public String registerUser(String username, String password, String accountType) {
        return "employee_login";
    }
}
