package com.example.hotelbooking.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.hotelbooking.bean.Check_out;
import com.example.hotelbooking.bean.Checkin_report;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CheckoutMapper extends BaseMapper<Check_out> {
}
