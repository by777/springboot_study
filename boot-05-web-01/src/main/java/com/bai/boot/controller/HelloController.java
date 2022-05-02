package com.bai.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    // 请求进来，先去找Controller看能不能处理，不能处理的请求交给静态资源处理器
    @RequestMapping("/bug.jpeg")
    public String hello(){
        return "aaaaa";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String getUser(){
        return "GET - 张三";
    }
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String saveUser(){
        return "POST - 张三";
    }
    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public String putUser(){
        return "PUT - 张三";
    }
    @RequestMapping(value = "/user", method = RequestMethod.DELETE)
    public String deleteUser(){
        return "DELETE - 张三";
    }


}
