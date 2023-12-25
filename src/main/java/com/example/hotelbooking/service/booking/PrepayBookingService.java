package com.example.hotelbooking.service.booking;

import com.example.hotelbooking.bean.Bookings;
import org.springframework.beans.factory.annotation.Autowired;

public class PrepayBookingService extends BookingsService{
    private final String type="预付金预定";

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

