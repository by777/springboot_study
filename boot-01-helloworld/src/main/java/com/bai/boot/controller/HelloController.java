package com.bai.boot.controller;

import ch.qos.logback.core.db.DBHelper;
import com.bai.boot.bean.Car;
import com.bai.boot.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Import({User.class, DBHelper.class}) // 给容器中导入非常多的组件
@RestController // @RestController = @ResponseBody +  @Controller
public class HelloController {
    // @ResponseBody 返回值作为返回的字符串，而非视图。也可以直接写道类上面，避免每个方法都要加
    @Autowired
    Car car;

    @RequestMapping("/hello")
    public String handle01(@RequestParam("name") String name) {
        log.info("请求进来了。。。");
        return "[ Hello spring boot 2 ]" + name;
    }

    @RequestMapping("/car")
    public Car car() {
        return car;
    }
}
