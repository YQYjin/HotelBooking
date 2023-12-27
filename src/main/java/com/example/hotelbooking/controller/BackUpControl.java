package com.example.hotelbooking.controller;

import com.example.hotelbooking.service.BackUpService;
import com.example.hotelbooking.service.BasePriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class  BackUpControl {
    @Autowired
    private BackUpService backUpService;
    @GetMapping("/backup")
    public String backUp(){
        return backUpService.backUp();
    }
}
