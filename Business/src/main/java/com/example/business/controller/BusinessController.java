package com.example.business.controller;

import com.example.business.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BusinessController {

    @Autowired
    private BusinessService businessService;

    @RequestMapping("/getPoMessage")
    public String getPoMessage(@RequestParam(required = true) Integer id){
        return businessService.getPoMessage(id);
    }
}
