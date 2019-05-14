package com.example.business.entity;

import lombok.Data;

import java.util.Date;

@Data
public class PoMessage {
    private Integer id;

    private String title;

    private Date createTime;

    private Date updateTime;

    private String sender;

    private Integer type;

    private String content;
}