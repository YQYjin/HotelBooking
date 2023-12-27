package com.example.hotelbooking.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.hotelbooking.bean.Bookings;
import com.example.hotelbooking.bean.Check_out;
import com.example.hotelbooking.bean.Checkin;
import com.example.hotelbooking.bean.Fine;
import com.example.hotelbooking.mapper.BookingsMapper;
import com.example.hotelbooking.mapper.CheckinMapper;
import com.example.hotelbooking.mapper.CheckoutMapper;
import com.example.hotelbooking.mapper.FineMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class FineService {
    @Autowired
    private FineMapper fineMapper;
    @Autowired
    private BookingsMapper bookingsMapper;

    // 获取罚单
    public Fine getTicket(String username){
        QueryWrapper<Fine> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("user",username);
        Fine fine=fineMapper.selectOne(queryWrapper);
        return fine;
    }
    // 生成罚单
    public String GenerateTicket(String username,String reason,String finePrice) {
        Fine fine=new Fine();
        double doubleFine=Double.parseDouble(finePrice);
        fine.setFine(doubleFine);
        fine.setUsername(username);
        fine.setReason(reason);
        fineMapper.insert(fine);
        return "true";
//        QueryWrapper<Bookings> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("username", username);
//        //查询日期最近的结果
//        queryWrapper.orderByDesc("start_date");
//        queryWrapper.last("LIMIT 1");
//        List<Bookings> bookingsList = bookingsMapper.selectList(queryWrapper);
//        Bookings booking=bookingsList.get(0);
//        String type=booking.getType();
//        if(type.equals("yufuj"))
    }
    public Fine getByUser(String username){
        QueryWrapper<Fine> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user",username);
        queryWrapper.orderByDesc("id");
        Fine response=fineMapper.selectOne(queryWrapper);
        return response;
    }
}
