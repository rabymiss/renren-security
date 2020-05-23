package com.example.servlet.entity;

import lombok.Data;

@Data
public class CpnMsgEn {
    private int id;

    private  String username;
    private String   nickname;
    private String icon;
    private String burthday;
    private String email;
    private String phonenumber;
    private String addressp;

    //zhanghao
    private String workin;
    private String showyou;
}
