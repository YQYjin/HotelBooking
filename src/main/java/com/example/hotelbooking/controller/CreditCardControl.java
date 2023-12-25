package com.example.hotelbooking.controller;


import com.example.hotelbooking.bean.Credit_card;
import com.example.hotelbooking.service.CreditCardService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class CreditCardControl {
    @Resource
    private CreditCardService creditCardService;

    // 获取信用卡信息
    @PostMapping("/getCreditCardData")
    public List<Credit_card> getCreditCardData(String username) {
        List<Credit_card> list=creditCardService.getCreditCard(username);
        return list;
    }

    // 添加信用卡
    @PostMapping("/addcreditcard")
    public String addCreditCard(String username,String cardNumber,String cardHolder){
        String response=creditCardService.addCreditCard(username,cardNumber,cardHolder);
        return response;
    }

    // 删除信用卡
    @PostMapping("/deletecreditcard")
    public String deleteCreditCard(String username,String cardNumber){
        String response=creditCardService.deleteCreditCard(username,cardNumber);
        return response;
    }
}
