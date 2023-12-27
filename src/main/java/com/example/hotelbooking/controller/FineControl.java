package com.example.hotelbooking.controller;

import com.example.hotelbooking.bean.Fine;
import com.example.hotelbooking.service.FineService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.swing.plaf.PanelUI;

@RestController
public class FineControl {
    @Resource
    private FineService fineService;

    @PostMapping("/getticket")
    // 获取罚单
    public Fine getTicket(String username){
        Fine response=fineService.getTicket(username);
        return response;
    }
    // 生成罚单
    @PostMapping("/generateticket")
    public String generateTicker(String username,String reason,String finePrice){
        String response=fineService.GenerateTicket(username, reason, finePrice);
        return response;
    }
    @GetMapping("/punish")
    public Fine getByUser(String username){
        return fineService.getByUser(username);
    }
}
