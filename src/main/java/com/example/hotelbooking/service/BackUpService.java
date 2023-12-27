package com.example.hotelbooking.service;

import com.example.hotelbooking.mapper.BasePriceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BackUpService {
    public String backUp(){
        return "true";
    }
}
