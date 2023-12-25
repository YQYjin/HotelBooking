package com.example.hotelbooking.bean;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Credit_card {
    @TableId(value = "id")
    private int id;
    private String cardNumber;
    private String cardHolder;
    private String username;
}
