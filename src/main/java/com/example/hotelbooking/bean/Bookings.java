package com.example.hotelbooking.bean;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Bookings {
    @TableId(value = "bookno")
    private int bookno;
    private String username;
    private String time;
    private String type;
}
