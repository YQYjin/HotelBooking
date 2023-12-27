package com.example.hotelbooking.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.hotelbooking.bean.Check_out;
import com.example.hotelbooking.bean.Reward_report;
import com.example.hotelbooking.mapper.CheckoutMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckoutService {
    @Autowired
    private CheckoutMapper checkoutMapper;
    public Check_out getByUser(String username){
        QueryWrapper<Check_out> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user",username);
        queryWrapper.orderByDesc("time");
        Check_out response=checkoutMapper.selectOne(queryWrapper);
        return response;
    }
}
