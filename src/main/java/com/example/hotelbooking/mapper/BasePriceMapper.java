package com.example.hotelbooking.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.hotelbooking.bean.Basic_data;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BasePriceMapper extends BaseMapper<Basic_data> {
}
