package com.example.hotelbooking.service.booking;

import com.example.hotelbooking.bean.Bookings;
import org.springframework.beans.factory.annotation.Autowired;

public class PrepayBookingService extends BookingsService{
    private final String type="预付金预定";

    @Override
    public String makeBooking(String username,String startDate,String endDate,String creditno){
        if(!cheackcredit(username, creditno)){
            return "false";
        }
        Bookings bookings=new Bookings();
        bookings.setUsername(username);
        bookings.setStartDate(startDate);
        bookings.setEndDate(endDate);
        bookings.setType(type);
        // 获取基价
        double basePrice=getBasePrice();
        bookings.setBasePrice(basePrice);
        // TODO: 计算总价
        double totalPrice=calculateTotalPrice(basePrice);
        bookings.setTotalPrice(totalPrice);
        bookingsMapper.insert(bookings);
        return "true";
    }
    //计算总价
    private double calculateTotalPrice(double basePrice){
        return basePrice*0.75;
    }
}

