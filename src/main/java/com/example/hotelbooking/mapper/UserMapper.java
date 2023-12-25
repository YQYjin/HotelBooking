package com.example.hotelbooking.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.hotelbooking.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.context.annotation.Bean;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}