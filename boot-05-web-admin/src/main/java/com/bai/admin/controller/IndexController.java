package com.bai.admin.controller;

import com.bai.admin.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    @GetMapping(value = {"/", "login"})
    public String loginPage(){
        return "login";
    }

    @PostMapping("/login")
    public String main (User user, HttpSession session, Model model){
        // 防止表单重复提交
        if (StringUtils.isEmpty(user.getUsername()) && "123456".equals(user.getPassword())){
            session.setAttribute("loginUser",user);
            return "redirect:/main.html";
        }else {
            model.addAttribute("msg", "账号密码错误");
            return "login";
        }
    }

    @GetMapping("/main.html")
    public String mainPage(HttpSession session,Model model){
        Object loginUser = session.getAttribute("loginUser");
        if (loginUser!=null){
            return "main";
        }
        else {
            model.addAttribute("msg", "还没有登录");
            return "login";
        }
    }
}

