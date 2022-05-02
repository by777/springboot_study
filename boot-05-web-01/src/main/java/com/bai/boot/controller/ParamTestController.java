package com.bai.boot.controller;

import org.springframework.boot.web.servlet.server.Session;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ParamTestController {
    @GetMapping("/car/{id}/owner/{username}")
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
}
