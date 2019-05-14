package com.example.service.service;

import com.alibaba.fastjson.JSON;
import com.example.common.exception.CustomException;
import com.example.mysql.annotation.DataBase;
import com.example.service.dao.TUserMapper;
import com.example.service.entity.TUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @Autowired
    private TUserMapper tUserMapper;

    @DataBase("local")
    public String getTUser(Integer tId) {
        TUser tUser = tUserMapper.selectByPrimaryKey(tId);
        return JSON.toJSONString(tUser);
    }

    public String exceptionMethod() {
        int i = 1 / 0;
        return i + "";
    }

    public String customExceptionMethod(String string) {
        throw new CustomException("message" + string, "customExceptionMethod", "descInfo");
    }
}
