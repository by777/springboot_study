package com.bai.boot.controller;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class RequestController {

    @GetMapping("/goto")
    public String goToPage(HttpServletRequest request) {
        request.setAttribute("msg", "成功了。。。");
        request.setAttribute("code", "200");
        return "forward:/success";//转发
    }

    @ResponseBody
    @GetMapping("/success")
    public Map<String, Object> success(@RequestAttribute("msg") String msg,
                                       @RequestAttribute("code") String code,
                                       HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        Object msg1 = request.getAttribute("msg");
        map.put("使用Request_Method取到的msg", msg1);
        map.put("使用注解取到的msg", msg);
        return map;
    }
}
