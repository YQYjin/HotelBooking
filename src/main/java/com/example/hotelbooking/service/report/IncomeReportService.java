package com.example.hotelbooking.service.report;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.hotelbooking.bean.Checkin_report;
import com.example.hotelbooking.bean.Income_report;
import com.example.hotelbooking.mapper.CheckinReportMapper;
import com.example.hotelbooking.mapper.IncomeReportMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service

public class IncomeReportService {
    @Autowired
    IncomeReportMapper incomeReportMapper;
    public List<Income_report> getIncomeReport(Date startDate, Date endDate){
        QueryWrapper<Income_report> queryWrapper = new QueryWrapper<>();
        queryWrapper.between("date", startDate, endDate);
        // 如果你的字段名是 endTime，也可以使用 queryWrapper.between("end_time", startTime, endTime);

        return incomeReportMapper.selectList(queryWrapper);
    }
}
