package com.example.hotelbooking.service;

import com.example.hotelbooking.bean.Bookings;
import com.example.hotelbooking.bean.Checkin;
import com.example.hotelbooking.mapper.BookingsMapper;
import com.example.hotelbooking.mapper.CheckinMapper;
import com.example.hotelbooking.service.booking.BookingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class CheckInService {
    @Resource
    private RoomService roomService;
    @Resource
    private BookingsService bookingsService;
    @Autowired
    private BookingsMapper bookingsMapper;
    @Autowired
    private CheckinMapper checkinMapper;
    public String checkinRoom(String bookno){
        Checkin checkin=new Checkin();
        // 获取房间号
        int roomNo=roomService.getRoom();
        if(roomNo==-1) {
            return "-1";
        }
        // 修改房间状态
        String result=roomService.changeRoomStatus(roomNo,1);
        String strRoomNo=String.valueOf(roomNo);

        // 获取预订信息
        Bookings booking=bookingsMapper.selectById(bookno);
        String userName=booking.getUsername();
        String endDate=booking.getEndDate();
        endDate=endDate+" 23:59:59";

        // 获取当前时间
        LocalDateTime currentDateTime = LocalDateTime.now();
        // 自定义格式化字符串
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = currentDateTime.format(formatter);

        checkin.setRoomNumber(strRoomNo);
        checkin.setBookingId(booking.getBookno());
        checkin.setName(userName);
        checkin.setCheckinTime(formattedDateTime);
        checkin.setDepartureDate(endDate);
        checkinMapper.insert(checkin);

        return String.valueOf(roomNo);
    }

}
