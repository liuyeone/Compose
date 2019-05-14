package com.example.common.exception;

import lombok.Data;

@Data
public class CustomException extends RuntimeException {

    // 异常信息
    private String message;

    // 发生的方法
    private String method;

    // 描述
    private String descInfo;

    public CustomException(String message, String method, String descInfo){
        this.message = message;
        this.method = method;
        this.descInfo = descInfo;
    }
}
