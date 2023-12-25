package com.example.hotelbooking.controller;

import com.example.hotelbooking.bean.Fine;
import com.example.hotelbooking.service.FineService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class FineControl {
    @Resource
    private FineService fineService;

    @PostMapping("/generateticket")
    // 获取罚单
    public Fine getTicket(String username){
        Fine response=fineService.getTicket(username);
        return response;
    }
}