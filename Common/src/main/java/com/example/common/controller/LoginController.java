package com.example.common.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.common.service.UserService;
import com.example.common.util.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("common")
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("login")
    public AjaxResult<JSONObject> login(@RequestParam(required = true) String username,
                                        @RequestParam(required = true) String password) {
        AjaxResult<JSONObject> result = new AjaxResult<>();
        JSONObject object = userService.login(username,password);
        result.setData(object);
        result.setSuccess(true);
        return result;
    }
}
