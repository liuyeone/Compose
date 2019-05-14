package com.example.business.service;

import com.alibaba.fastjson.JSON;
import com.example.business.dao.PoMessageMapper;
import com.example.business.entity.PoMessage;
import com.example.mysql.annotation.DataBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessService {

    @Autowired
    private PoMessageMapper poMessageMapper;

    @DataBase("project")
    public String getPoMessage(Integer id){
        PoMessage message = poMessageMapper.selectByPrimaryKey(id);
        return JSON.toJSONString(message);
    }
}
