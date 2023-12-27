package com.example.hotelbooking.controller;

import com.example.hotelbooking.bean.Check_out;
import com.example.hotelbooking.service.CheckoutService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class CheckoutControl {
    @Resource
    CheckoutService checkoutService;
    @GetMapping("/payment")
    public Check_out getByUser(String username){
        return checkoutService.getByUser(username);
    }
}
