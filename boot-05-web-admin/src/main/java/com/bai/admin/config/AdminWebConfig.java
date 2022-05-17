package com.bai.admin.config;

import com.bai.admin.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AdminWebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").excludePathPatterns("/", "/login", "/css/**", "/js/**", "/fonts/**", "/images/**", "/static/**", "/templates/**"); // 拦截全部但是放行两个，还需要放行静态资源
    }
}

