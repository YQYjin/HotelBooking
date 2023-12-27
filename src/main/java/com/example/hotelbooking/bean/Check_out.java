package com.example.hotelbooking.bean;

import lombok.Data;

@Data
public class Check_out {
    private int id;
    private String user;
    private String hotel;
    private String time;
    private double amount;
}
