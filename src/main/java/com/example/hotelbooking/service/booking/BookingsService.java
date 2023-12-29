package com.example.hotelbooking.service.booking;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.hotelbooking.bean.Bookings;
import com.example.hotelbooking.bean.Rooms;
import com.example.hotelbooking.mapper.BookingsMapper;
import com.example.hotelbooking.mapper.RoomsMapper;
import com.example.hotelbooking.service.BasePriceService;
import com.example.hotelbooking.service.CreditCardService;
import com.example.hotelbooking.service.FineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import javax.annotation.Resource;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
    public static int roomCount=45;
    // 预订,会被子类重写
    public String makeBooking(String username, String startTime,String endTime) throws ParseException {
        return "false";
    }
    // 取消预订
    public String cancelBooking(String id){
        roomCount=roomCount+1;
        Bookings bookings=bookingsMapper.selectById(id);
        System.out.println(id);
        System.out.println(bookings.getStatus());
        bookings.setStatus(0);
        System.out.println(bookings.getStatus());
        bookingsMapper.updateById(bookings);
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
    public String getTime(){
        // 获取当前日期
        LocalDateTime currentDateTime = LocalDateTime.now();

        // 定义日期格式化器
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");

        // 将当前日期格式化为字符串
        String currentDateAsString = currentDateTime.format(formatter);
        return currentDateAsString;
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
