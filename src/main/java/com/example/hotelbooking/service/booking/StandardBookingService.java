package com.example.hotelbooking.service.booking;

import com.example.hotelbooking.bean.Bookings;

public class StandardBookingService extends BookingsService{
    private final String type="常规预订";
    @Override
    public String makeBooking(String username,String startDate,String endDate){
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
        bookings.setTime(getTime());
        bookingsMapper.insert(bookings);
        return "true";
    }
    //计算总价
    private double calculateTotalPrice(double basePrice){
        return basePrice;
    }
}

