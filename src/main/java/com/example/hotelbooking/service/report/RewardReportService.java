package com.example.hotelbooking.service.report;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.hotelbooking.bean.Income_report;
import com.example.hotelbooking.bean.Reward_report;
import com.example.hotelbooking.mapper.IncomeReportMapper;
import com.example.hotelbooking.mapper.RewardReportMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service

public class RewardReportService {
    @Autowired
    RewardReportMapper rewardReportMapper;
    public List<Reward_report> getRewardReport(String startDate, String endDate){
        QueryWrapper<Reward_report> queryWrapper = new QueryWrapper<>();
        queryWrapper.between("date", startDate, endDate);
        // 如果你的字段名是 endTime，也可以使用 queryWrapper.between("end_time", startTime, endTime);

        return rewardReportMapper.selectList(queryWrapper);
    }
}