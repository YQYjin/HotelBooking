package com.example.hotelbooking.service.everydayreport;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.hotelbooking.MyType.EverydayReport;
import com.example.hotelbooking.bean.Checkin;
import com.example.hotelbooking.mapper.CheckinMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class EverydayStayService {
    @Autowired
    private CheckinMapper checkinMapper;

    public List<EverydayReport> getStayReport(String date) throws ParseException {
        // 定义日期格式
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date today=dateFormat.parse(date);
        List<EverydayReport> everydayStayReports=new ArrayList<>();
        // 查询全部住宿登记
        List<Checkin> allCheckin=checkinMapper.selectList(null);
        // 遍历全部住宿登记
        for(Checkin checkin:allCheckin){
            // 将时间转为日期
            String checkinTime=checkin.getCheckinTime();
            String checkinDateStr=checkinTime.substring(0, 10);
            Date checkinDate=dateFormat.parse(checkinDateStr);
            String departureTime=checkin.getDepartureDate();
            String departureDateStr=departureTime.substring(0,10);
            Date departureDate=dateFormat.parse(departureDateStr);
            // 如果住宿登记的入住时间在date之前，离开时间在date之后
            if(checkinDate.compareTo(today)<=0&&departureDate.compareTo(today)>=0){
                // 房间号
                String roomNumber=checkin.getRoomNumber();
                // 姓名
                String name=checkin.getName();
                // 如果当天离开,姓名前加*
                if(departureDate.compareTo(today)==0){
                    name="*"+name;
                }
                EverydayReport report=new EverydayReport();
                report.setRoomNumber(roomNumber);
                report.setName(name);
                report.setDepartureDate(departureDateStr);

            }
        }

        return everydayStayReports;
    }

}
