package com.example.hotelbooking.controller;

import com.example.hotelbooking.service.CheckInService;
import com.example.hotelbooking.service.CheckoutService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class CheckoutControl {
    @Resource
    private CheckoutService checkoutService;
    @PostMapping("/checkoutroom")
    public String checkOut(String bookno){
        String response=checkoutService.checkOut(bookno);
        return response;
    }
}
