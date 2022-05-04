package com.bai.boot.controller;

import org.springframework.boot.web.servlet.server.Session;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ParamTestController {
    @GetMapping("/car/{id}/owner/{username}/age/{age}")
    public Map<String, Object> getCar(
            @PathVariable("id") Integer id,
            @PathVariable("username") String name,
            @PathVariable() Map<String, String> pv,
            @RequestHeader("User-Agent") String userAgent,
            @RequestHeader Map<String, String> header,
            @RequestParam("age") Integer age,
            @RequestParam("interest") List<String> interests,
            @RequestParam Map<String, String> params
//            ,
//            @CookieValue("") Cookie cookie
//            ,
//            @CookieValue("_ga") Session.Cookie cookie
    ) {
        Map<String, Object> map = new HashMap<>();
//        map.put("id", id);
//        map.put("name", name);
//        map.put("pv", pv);
//        map.put("userAgent", userAgent);
//        map.put("headers", header);
        map.put("age", age);
        map.put("interests", interests);
        map.put("params", params);
        // map.put("_ga", _ga);
//        map.put("cookie", cookie);
        return map;
    }

    @PostMapping("/save")
    public Map<String, Object> postMethod(@RequestBody String content) {
        Map<String, Object> map = new HashMap<>();
        map.put("content", content);
        return map;
    }

    // spring boot默认禁用了矩阵变量
    @GetMapping("/cars/{path}")
    public Map<String, Object> carsSell(@MatrixVariable("low") Integer low, @MatrixVariable("brand") List<String> brand, @PathVariable("path") String path) {
        Map<String, Object> map = new HashMap<>();
        // /cars/sell;low=34,brand=byd,audi,yd
        map.put("low", low);
        map.put("brand", brand);
        map.put("path", path);
        return map;

    }

    // /boss/1;age=30/2;age=22
    @GetMapping("/boss/{bossId}/{empId}")
    public Map<String, Object> boss(@MatrixVariable(value = "age", pathVar = "bossId") Integer bossAge,
                                    @MatrixVariable(pathVar = "empId", value = "age") Integer empAge) {

        Map<String, Object> map = new HashMap<>();
        map.put("bossAge", bossAge);
        map.put("empAge", empAge);
        return map;


    }
}
