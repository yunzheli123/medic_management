package com.yunzheli.medic_system.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class controller {
    @CrossOrigin
    @RequestMapping("/test")
    public String test(){
        return "ok";
    }
}
