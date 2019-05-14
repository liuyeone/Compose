package com.example.service.controller;

import com.example.service.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping("/getTUser")
    public String getTUser(@RequestParam(required = true) Integer id) {
        return testService.getTUser(id);
    }

    @RequestMapping("/exceptionMethod")
    public String exceptionMethod() {
        return testService.exceptionMethod();
    }

    @RequestMapping("/customExceptionMethod")
    public String customExceptionMethod(String string) {
        return testService.customExceptionMethod(string);
    }
}
