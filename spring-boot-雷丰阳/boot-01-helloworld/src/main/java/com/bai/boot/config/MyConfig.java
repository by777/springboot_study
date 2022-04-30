package com.bai.boot.config;

import com.bai.boot.bean.Pet;
import com.bai.boot.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false) // 告诉Spring boot这时一个配置类(其自身也是一个组件)
// proxyBeanMethods：是否是代理bean的方法
// 外部无论对这个配置类中的组件注册方法调用多少次，获取的都是之前注册到容器的单实例对象
/*
 * User user01 = bean.user01();
 * User user02 = bean.user01();
 * System.out.println(user01 == user02); true
 *
 * 如果为false, 则user01 != user02
 *
 * Full(proxyBeanMethods = true)
 * Lite(proxyBeanMethods = true)
 * 用以解决组件依赖
 * 组件有依赖就true，用Lite模式，否则false，用Full模式
 * */

public class MyConfig {
    @Bean // 给容器添加组件，以方法名作为组件id，返回类型是组件类型。返回的值就是组件在容器中的实例
    public User user01() {
        User zhangsan = new User("zhang_san", 18);
        // User组件依赖了pet组件
        // proxyBeanMethods = true是成立的
        zhangsan.setPet(tomcatPet());
        return zhangsan;
    }

    @Bean("tom")
    public Pet tomcatPet() {
        return new Pet("tomcat");
    }
}
