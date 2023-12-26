package com.example.hotelbooking.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.hotelbooking.bean.User;
import com.example.hotelbooking.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    public String registerUser(String username, String password, String accountType) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setAccountType(accountType);
        // 根据用户名搜索
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        User user1 = userMapper.selectOne(queryWrapper);
        if (user1 != null) {
            return "false";
        }
        userMapper.insert(user);
        return "true";
    }
    public String userLogin(String username ,String password)
    {
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("username",username);
        queryWrapper.eq("password",password);
        User user1=userMapper.selectOne(queryWrapper);
        if(user1 !=null){
            return "true";
        }
        else return "false";
    }
}
