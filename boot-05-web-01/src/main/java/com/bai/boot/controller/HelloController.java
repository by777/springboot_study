package com.bai.boot.controller;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
public class HelloController {

    // 请求进来，先去找Controller看能不能处理，不能处理的请求交给静态资源处理器
    //@RequestMapping("/bug.jpeg")
    @GetMapping("/bug.jpg")
    public String hello(@RequestParam("username") String name) {
        // @RequestParam("username") String name从请求参数的位置拿到username给name使用
        // 还可以使用HttpSession，Model

        return "aaaaa";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String getUser() {
        return "GET - 张三";
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String saveUser() {
        return "POST - 张三";
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public String putUser() {
        return "PUT - 张三";
    }

    @RequestMapping(value = "/user", method = RequestMethod.DELETE)
    public String deleteUser() {
        return "DELETE - 张三";
    }


}
