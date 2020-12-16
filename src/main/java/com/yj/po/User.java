package com.yj.po;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private String salt;
    private String email;
    private Integer type; //0:普通用户,1：超级管理员，2：版主
    private Integer status;//0：未激活，1：已激活
    private String activation_code;
    private String headerUrl;
    private Date createTime;
}
