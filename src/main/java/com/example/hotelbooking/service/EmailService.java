package com.example.hotelbooking.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.hotelbooking.bean.Email;
import com.example.hotelbooking.mapper.EmailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private EmailMapper emailMapper;

    // 更新邮箱
    public String updateEmail(String username,String newEmail){
        QueryWrapper<Email> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        Email email=emailMapper.selectOne(queryWrapper);
        if(email==null){
            Email newEmail1=new Email();
            newEmail1.setUsername(username);
            newEmail1.setEmail(newEmail);
            emailMapper.insert(newEmail1);
        }
        else{
            email.setEmail(newEmail);
            emailMapper.updateById(email);
        }
        return "true";
    }
}
