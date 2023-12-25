package com.example.hotelbooking.bean;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class User {
    @TableId(value = "id")
    private int id;
    private String username;
    private String password;
    private String accountType;

}
