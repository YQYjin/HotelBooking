package com.example.hotelbooking.bean;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Bookings {
    @TableId(value = "bookno")
    private int bookno;
    private String username;
    private String type;
    private int roomno;
    private double basePrice;
    private double totalPrice;
    private int status;
    private String startDate;
    private String endDate;
    private String time;

}
