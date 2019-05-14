package com.example.common.entity;

import lombok.Data;

import java.util.Date;

@Data
public class PoUser {
    private Long id;

    private String username;

    private String email;

    private String mobile;

    private String password;

    private Integer status;

    private Integer admin;

    private String descname;

    private String avatar;

    private Date createTime;

    private Date updateTime;
}