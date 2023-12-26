package com.example.hotelbooking.service.booking;

import com.example.hotelbooking.bean.Bookings;

public class RewardBookingService extends BookingsService{
    private final String type="奖励预订";
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
        bookingsMapper.insert(bookings);
        return "true";
    }
}
