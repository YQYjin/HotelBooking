package com.example.hotelbooking.controller;

import com.example.hotelbooking.service.CheckInService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class CheckinControl {
    @Resource
    private CheckInService checkInService;
    @PostMapping("/checkinroom")
    public String checkinRoom(String bookno){
        String response=checkInService.checkinRoom(bookno);
        return response;
    }
    @PostMapping("/checkoutroom")
    public String checkOut(String bookno){
        String response=checkInService.checkOut(bookno);
        return response;
    }
}
