package com.bai.boot.config;

import org.springframework.boot.autoconfigure.web.servlet.ConditionalOnMissingFilterBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

@Configuration(proxyBeanMethods = false) // 配置类，容器组件之间没有依赖，false直接放
public class WebConfig implements WebMvcConfigurer {
    @Bean
    public HiddenHttpMethodFilter hiddenHttpMethodFilter() {
        HiddenHttpMethodFilter hiddenHttpMethodFilter = new HiddenHttpMethodFilter();
        hiddenHttpMethodFilter.setMethodParam("_method"); //此处修改RESTFUL flag
        return hiddenHttpMethodFilter;
    }

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        UrlPathHelper urlPathHelper = new UrlPathHelper();
        urlPathHelper.setRemoveSemicolonContent(false);//不移除分号后面的内容，矩阵变量生效
        configurer.setUrlPathHelper(urlPathHelper);
    }

// or @Bean // WebMvcConfig

}
