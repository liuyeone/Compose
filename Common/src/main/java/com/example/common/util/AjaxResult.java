package com.example.common.util;

import lombok.Data;

@Data
public class AjaxResult<T> {
    private boolean success;
    private int errorNo = 0; // 0,成功；1，未登录
    private String errorMsg;
    private T data;
    private int loginStatus = 1;
}