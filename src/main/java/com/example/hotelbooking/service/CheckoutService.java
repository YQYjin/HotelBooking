package com.example.hotelbooking.service;


import com.example.hotelbooking.bean.Bookings;
import com.example.hotelbooking.mapper.BookingsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.hotelbooking.bean.Check_out;
import com.example.hotelbooking.bean.Reward_report;
import com.example.hotelbooking.mapper.CheckoutMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

@Service
public class CheckoutService {
    @Resource
    private RoomService roomService;
    @Autowired
    private BookingsMapper bookingsMapper;

    public String checkOut(String bookno) {
        // 获取预订信息
        Bookings booking = bookingsMapper.selectById(bookno);
        int roomNo = booking.getRoomno();
        // 将房间设为空置
        roomService.changeRoomStatus(roomNo, 0);
        return "true";
    }

    @Autowired
    private CheckoutMapper checkoutMapper;

    public Check_out getByUser(String username) {
        QueryWrapper<Check_out> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user", username);
        queryWrapper.orderByDesc("time");
        Check_out response = checkoutMapper.selectOne(queryWrapper);
        return response;
    }
}

