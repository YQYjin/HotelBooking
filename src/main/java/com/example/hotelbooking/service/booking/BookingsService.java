package com.example.hotelbooking.service.booking;


import com.example.hotelbooking.mapper.BookingsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingsService {
    @Autowired
    protected BookingsMapper bookingsMapper;
    // 预订,会被子类重写
    public String makeBooking(String username, String time){
        return "false";
    }
    // 删除预订
    public String cancelBooking(String id){
        int rowsAffected = bookingsMapper.deleteById(id);
        if(rowsAffected==1)
            return "true";
        else
            return "false";
    }
}
