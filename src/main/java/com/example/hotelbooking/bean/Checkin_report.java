package com.example.hotelbooking.bean;

import lombok.Data;

@Data
public class Checkin_report {
    private String date;
    private int prepayment;
    private int prepayment60;
    private int regularBooking;
    private int rewardBooking;
    private int totalRooms;
}
