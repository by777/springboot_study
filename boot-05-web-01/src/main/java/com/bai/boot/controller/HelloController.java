package com.bai.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    // 即使存在bug.jpg，会优先访问controller，bug1.jpeg正常访问
    @RequestMapping("/bug.jpeg")
    public String hello(){
        return "aaaaa";
    }
}
