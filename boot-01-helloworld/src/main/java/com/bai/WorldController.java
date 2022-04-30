package com.bai;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * 这个包在MainApplication上级，默认不会装配
 * */
@RestController
public class WorldController {
    @RequestMapping("/w")
    public String world66() {
        return "这里默认是会访问不到（404），" +
                "但是如果在" +
                "@SpringBootApplication(scanBasePackages = \"com.bai\")" +
                "配置就可以了";
    }
}
