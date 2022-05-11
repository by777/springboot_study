package com.bai.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewTestController {
    @GetMapping("/atguigu")
    public String atguigu(Model model) {
        // model中的数据会被放在请求区域中，request.setAttribute()
        model.addAttribute("msg", "你好 bai");
        model.addAttribute("link", "https://www.baidu.com");
        return "success";//success.html
    }
}
