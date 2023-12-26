package com.example.hotelbooking.controller;

import com.example.hotelbooking.service.booking.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class BookingContorl {
    @Resource
    private BookingsService bookingsService;
    @Resource
    private RewardBookingService rewardBookingService;
    @Resource
    private PrepayBookingService prepayBookingService;
    @Resource
    private AdvanceBookingService advanceBookingService;
    @Resource
    private StandardBookingService standardBookingService;

    @PostMapping("/booking")
    // 预订
    public String booking(String username,String bookingType,String startDate,String endDate,String creditno){
        if(bookingType.equals("1")){
            String response=prepayBookingService.makeBooking(username,startDate,endDate,creditno);
            return response;
        } else if (bookingType.equals("2")) {
            String response=advanceBookingService.makeBooking(username,startDate,endDate,creditno);
            return response;
        } else if (bookingType.equals("3")) {
            String response=standardBookingService.makeBooking(username,startDate,endDate,creditno);
            return response;
        } else if (bookingType.equals("4")) {
            String response=rewardBookingService.makeBooking(username,startDate,endDate,creditno);
            return response;
        } else {
            return "false";
        }
    }

    @PostMapping("/cancelbooking")
    // 取消预订
    public String cancelBooking(String bookingNo){
        String response=bookingsService.cancelBooking(bookingNo);
        return response;
    }

    @PostMapping("/delete_booking")
    // 删除预订
    public String deleteBooking(String bookno){
        String response=bookingsService.deleteBooking(bookno);
        return response;
    }
}
