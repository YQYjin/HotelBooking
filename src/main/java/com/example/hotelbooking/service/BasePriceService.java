package com.example.hotelbooking.service;

import com.example.hotelbooking.bean.Basic_data;
import com.example.hotelbooking.mapper.BasePriceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BasePriceService {
    @Autowired
    private BasePriceMapper basePriceMapper;

    public double getBasePrice(){
        Basic_data basicData=basePriceMapper.selectById(0);
        double basePrice=basicData.getPrice();
        return basePrice;
    }
    public String changeBasePrice(double price){
        Basic_data basicData=basePriceMapper.selectById(0);
        basicData.setPrice(price);
        int rowsAffected=basePriceMapper.updateById(basicData);
        if(rowsAffected==1)
            return "true";
        else
            return "false";
    }

}
