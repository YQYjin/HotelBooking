package com.example.hotelbooking.service.report;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.hotelbooking.bean.Checkin_report;
import com.example.hotelbooking.mapper.CheckinMapper;
import com.example.hotelbooking.mapper.CheckinReportMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
public class CheckInReportService {
    @Autowired
    CheckinReportMapper checkinReportMapper;
    public List<Checkin_report> getCheckinReport(Date startDate, Date endDate){
        QueryWrapper<Checkin_report> queryWrapper = new QueryWrapper<>();
        queryWrapper.between("departure_date", startDate, endDate);
        // 如果你的字段名是 endTime，也可以使用 queryWrapper.between("end_time", startTime, endTime);

        return checkinReportMapper.selectList(queryWrapper);
    }
}
