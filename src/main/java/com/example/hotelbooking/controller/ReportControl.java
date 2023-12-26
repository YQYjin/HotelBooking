package com.example.hotelbooking.controller;

import ch.qos.logback.core.encoder.EchoEncoder;
import com.example.hotelbooking.bean.Checkin;
import com.example.hotelbooking.bean.Checkin_report;
import com.example.hotelbooking.bean.Income_report;
import com.example.hotelbooking.bean.Reward_report;
import com.example.hotelbooking.service.report.CheckInReportService;
import com.example.hotelbooking.service.report.IncomeReportService;
import com.example.hotelbooking.service.report.RewardReportService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@RestController
public class ReportControl {
    @Resource
    private CheckInReportService checkInReportService;
    @Resource
    private IncomeReportService incomeReportService;
    @Resource
    private RewardReportService rewardReportService;
    @PostMapping("/getrewardreport")
    public List<Reward_report> getRewardReport(Date startDate, Date endDate)
    {
        return rewardReportService.getRewardReport(startDate,endDate);
    }
    @PostMapping("/getincomereport")
    public List<Income_report> getIncomeReport(Date startDate, Date endDate)
    {
        return incomeReportService.getIncomeReport(startDate,endDate);
    }
    @PostMapping("/getcheckinreport")
    public List<Checkin_report> getCheckinReport(Date startDate, Date endDate)
    {
        return checkInReportService.getCheckinReport(startDate,endDate);
    }
}
