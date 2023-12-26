package com.example.hotelbooking.controller;

import com.example.hotelbooking.MyType.EverydayReport;
import com.example.hotelbooking.service.everydayreport.EverydayArrivalService;
import com.example.hotelbooking.service.everydayreport.EverydayStayService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.List;

@RestController
public class EverydayReportControl {
    @Resource
    private EverydayArrivalService everydayArrivalService;
    @Resource
    private EverydayStayService everydayStayService;

    @PostMapping("/arrival_report")
    public List<EverydayReport> getArrivalReport(String date){
        return everydayArrivalService.getArrivalReport(date);
    }
    @PostMapping("/checkin_report")
    public List<EverydayReport> getStayReport(String date) throws ParseException {
        return everydayStayService.getStayReport(date);
    }
}
