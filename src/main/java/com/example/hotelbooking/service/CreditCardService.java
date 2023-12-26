package com.example.hotelbooking.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.hotelbooking.bean.Credit_card;
import com.example.hotelbooking.mapper.CreditCardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditCardService {
    @Autowired
    private CreditCardMapper creditCardMapper;

    // 根据用户名获取信用卡信息
    public List<Credit_card> getCreditCard(String username) {
        QueryWrapper<Credit_card> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        List<Credit_card> credit_cards = creditCardMapper.selectList(queryWrapper);

        return credit_cards;
    }

    // 添加信用卡
    public String addCreditCard(String username,String cardNumber,String cardHolder){
        Credit_card creditCard=new Credit_card();
        creditCard.setUsername(username);
        creditCard.setCardNumber(cardNumber);
        creditCard.setCardHolder(cardHolder);
        creditCardMapper.insert(creditCard);
        return "true";
    }

    // 删除信用卡
    public String deleteCreditCard(String username,String cardNumber){
        QueryWrapper<Credit_card> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        queryWrapper.eq("cardNumber", cardNumber);
        creditCardMapper.delete(queryWrapper);
        return "true";
    }
    // 检验信用卡
    public Boolean check(String username,String creditno){
        QueryWrapper<Credit_card> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("username", username);
        queryWrapper.eq("card_number", creditno);
        Credit_card credit_cards=creditCardMapper.selectOne(queryWrapper);
        if(credit_cards==null){
            return false;
        }else{
            return true;
        }
    }
}
