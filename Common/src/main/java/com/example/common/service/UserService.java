package com.example.common.service;

import com.alibaba.fastjson.JSONObject;
import com.example.common.dao.PoUserMapper;
import com.example.common.entity.PoUser;
import com.example.common.entity.PoUserExample;
import com.example.common.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private PoUserMapper poUserMapper;

    public JSONObject login(String username, String password) {
        JSONObject result = new JSONObject();

        PoUserExample example = new PoUserExample();
        example.createCriteria().andUsernameEqualTo(username).andPasswordEqualTo(password);

        List<PoUser> list = poUserMapper.selectByExample(example);
        if (null == list || list.size() == 0) {
            throw new CustomException("没有当前这个用户", "login", "账号或密码错误");
        }
        result.put("username", list.get(0).getUsername());
        result.put("descname", list.get(0).getDescname());
        return result;
    }
}
