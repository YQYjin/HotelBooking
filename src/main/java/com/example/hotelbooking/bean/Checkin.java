package com.example.hotelbooking.bean;

import lombok.Data;

@Data
public class Checkin {
    private int id;
    private String name;
    private String roomNumber;
    private String departureDate;
    private String checkinTime;
    private int bookingId;
}
