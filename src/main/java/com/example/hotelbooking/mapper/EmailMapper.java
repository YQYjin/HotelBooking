package com.example.hotelbooking.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.hotelbooking.bean.Email;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmailMapper extends BaseMapper<Email> {
}
