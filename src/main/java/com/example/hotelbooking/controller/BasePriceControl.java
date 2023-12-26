package com.example.hotelbooking.controller;

import com.example.hotelbooking.service.BasePriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasePriceControl {
    @Autowired
    private BasePriceService basePriceService;

    @PostMapping("/modify_price")
    public String modifyPrice(String newPrice){
        double basePrice=Double.parseDouble(newPrice);
        String response=basePriceService.changeBasePrice(basePrice);
        return response;
    }
    @GetMapping("/getprice")
    public String getPrice(){
        double basePrice=basePriceService.getBasePrice();
        String response=String.valueOf(basePrice);
        return response;
    }
}
