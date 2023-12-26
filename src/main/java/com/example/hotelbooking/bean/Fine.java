package com.example.hotelbooking.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

@Data
public class Fine {
    private int id;
    @TableField("user")
    private String username;
    private String reason;
    private double fine;
}
