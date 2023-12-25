package com.example.hotelbooking.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.hotelbooking.bean.Fine;
import com.example.hotelbooking.mapper.FineMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FineService {
    @Autowired
    private FineMapper fineMapper;

    // 获取罚单
    public Fine getTicket(String username){
        QueryWrapper<Fine> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("username",username);
        Fine fine=fineMapper.selectOne(queryWrapper);
        return fine;
    }
}
