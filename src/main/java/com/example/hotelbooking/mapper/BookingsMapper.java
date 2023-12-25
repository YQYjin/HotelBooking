package com.example.hotelbooking.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.hotelbooking.bean.Bookings;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookingsMapper extends BaseMapper<Bookings> {
}
