package com.example.hotelbooking.service.booking;

import com.example.hotelbooking.bean.Bookings;

public class StandardBookingService extends BookingsService{
    private final String type="常规预订";
    @Override
    public String makeBooking(String username, String time){
        Bookings bookings=new Bookings();
        bookings.setUsername(username);
        bookings.setTime(time);
        bookings.setType(type);
        bookingsMapper.insert(bookings);
        return "true";
    }
}
