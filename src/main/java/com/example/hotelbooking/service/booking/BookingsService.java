package com.example.hotelbooking.service.booking;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.hotelbooking.bean.Bookings;
import com.example.hotelbooking.bean.Checkin;
import com.example.hotelbooking.bean.Email;
import com.example.hotelbooking.bean.Rooms;
import com.example.hotelbooking.mapper.BookingsMapper;
import com.example.hotelbooking.mapper.RoomsMapper;
import com.example.hotelbooking.service.BasePriceService;
import com.example.hotelbooking.service.CreditCardService;
import com.example.hotelbooking.service.FineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.List;

@Service
public class BookingsService {
    @Autowired
    protected BookingsMapper bookingsMapper;
    @Autowired
    protected RoomsMapper roomsMapper;
    @Resource
    protected CreditCardService creditCardService;
    @Resource
    protected BasePriceService basePriceService;
    // 预订,会被子类重写
    public String makeBooking(String username, String startTime,String endTime,String creditno) throws ParseException {
        return "false";
    }
    // 取消预订
    public String cancelBooking(String id){
        Bookings bookings=bookingsMapper.selectById(id);
        bookings.setStatus(0);
        return "true";
    }
    public String deleteBooking(String id){
        int affectRows=bookingsMapper.deleteById(id);
        if(affectRows==1){
            return "true";
        }else{
            return "false";
        }
    }

    public double getBasePrice(){
        double basePrice=basePriceService.getBasePrice();
        return basePrice;
    }
    public Boolean cheackcredit(String username,String creditno){
        Boolean res=creditCardService.check(username,creditno);
        return res;
    }
    public List<Bookings> getBookings(String username)
    {
        QueryWrapper<Bookings> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        return bookingsMapper.selectList(queryWrapper);
    }
    public List<Bookings> showBookings(String date){
        QueryWrapper<Bookings> queryWrapper=new QueryWrapper<>();
        queryWrapper.like("time",date+"%");
        List<Bookings> bookings = bookingsMapper.selectList(queryWrapper);
        return bookings;
    }
}
