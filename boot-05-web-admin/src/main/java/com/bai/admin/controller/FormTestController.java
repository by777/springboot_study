package com.bai.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

// 文件上传
@Slf4j
@Controller
public class FormTestController {
    @GetMapping("/form_layouts")
    public String form_layouts() {
        return "form/form_layouts";
    }


    /**
     * 自动封装上传上来的文件
     */
    @PostMapping("/upload")
    public String upload(@RequestParam("email") String email,
                         @RequestParam("username") String username,
                         @RequestPart("headerImg") MultipartFile headerImg,
                         @RequestPart("photos") MultipartFile[] photos) {
        log.info("上传的信息{}{}{}{}", email, username, headerImg, photos);
        return "";
    }
}
