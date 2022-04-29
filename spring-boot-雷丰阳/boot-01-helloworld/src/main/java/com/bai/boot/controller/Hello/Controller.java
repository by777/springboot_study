package com.bai.boot.controller.Hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController // @RestController = @ResponseBody +  @Controller
public class Controller {
    // @ResponseBody// 返回值作为返回的字符串，而非视图。也可以直接写道类上面，避免每个方法都要加
    @RequestMapping("/hello")
    public String handle01() {
        return "Hello spring boot 2";
    }
}
