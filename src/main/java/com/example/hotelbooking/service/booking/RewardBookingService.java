package com.example.hotelbooking.service.booking;

import com.example.hotelbooking.bean.Bookings;
import com.example.hotelbooking.service.CheckRewardService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
@Service
public class RewardBookingService extends BookingsService{
    private final String type="4";
    @Resource
    private CheckRewardService checkRewardService;
    @Override
    public String makeBooking(String username,String startDate,String endDate) throws ParseException {
        Bookings bookings=new Bookings();
        bookings.setUsername(username);
        bookings.setStartDate(startDate);
        bookings.setEndDate(endDate);
        bookings.setType(type);
        // 获取基价
        double basePrice=getBasePrice();
        bookings.setBasePrice(basePrice);
        // 获取当前日期
        Date currentDate = new Date();
        // 判断是否可以进行奖励预订
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate2=dateFormat.parse(startDate);
        long differenceInMilliseconds = Math.abs(startDate2.getTime() - currentDate.getTime());
        long differenceInDays = differenceInMilliseconds / (24 * 60 * 60 * 1000);
        double totalPrice=basePrice;
        if(differenceInDays>=25) {
            if(checkRewardService.checkReward(currentDate,startDate2)){
                totalPrice=basePrice*0.8;
            }
        }
        bookings.setTotalPrice(totalPrice);
        bookings.setTime(getTime());
        bookingsMapper.insert(bookings);
        return "true";
    }
}
