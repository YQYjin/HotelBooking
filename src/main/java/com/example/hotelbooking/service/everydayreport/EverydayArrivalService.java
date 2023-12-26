package com.example.hotelbooking.service.everydayreport;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.hotelbooking.MyType.EverydayReport;
import com.example.hotelbooking.bean.Bookings;
import com.example.hotelbooking.bean.Checkin;
import com.example.hotelbooking.mapper.BookingsMapper;
import com.example.hotelbooking.mapper.CheckinMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EverydayArrivalService {
    @Autowired
    private CheckinMapper checkinMapper;
    @Autowired
    private BookingsMapper bookingsMapper;

    public List<EverydayReport> getArrivalReport(String date){
        // 根据日期查找记录
        QueryWrapper<Checkin> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("checkin_time", date+"%");
        List<Checkin> checkins = checkinMapper.selectList(queryWrapper);
        List<EverydayReport> everydayArrivalReports = new ArrayList<>();
        // 遍历,获取预订类别,并转为报告格式
        for(Checkin checkin:checkins){
            EverydayReport report=new EverydayReport();
            report.setRoomNumber(checkin.getRoomNumber());
            report.setName(checkin.getName());
            report.setDepartureDate(checkin.getDepartureDate());
            Bookings booking=bookingsMapper.selectById(checkin.getBookingId());
            report.setReservationType(booking.getType());
            everydayArrivalReports.add(report);
        }
        return everydayArrivalReports;
    }
}
