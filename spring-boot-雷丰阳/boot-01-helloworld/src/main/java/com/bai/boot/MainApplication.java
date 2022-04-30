package com.bai.boot;

import com.bai.boot.bean.Pet;
import com.bai.boot.bean.User;
import com.bai.boot.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/*
 * 主程序类
 * 这是一个Spring boot应用
 * 所谓IOC，对于spring框架来说，就是由spring来负责控制对象的生命周期和对象间的关系。
 * DI（Dependency Injection，依赖注入）。IOC的一个重点是在系统运行中，动态的向某个对象提供它所需要的其他对象。
 */
@SpringBootApplication(scanBasePackages = "com.bai")//scanBasePackages = "com.bai"
public class MainApplication {
    public static void main(String[] args) {
        // 1.返回我们的IoC容器
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);
        // 2.查看容器里的组件
        String[] names = run.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
        // 从容器中获取注册的组件，默认是单实例的
        Pet tom01 = run.getBean("tom", Pet.class);
        Pet tom02 = run.getBean("tom", Pet.class);
        System.out.println(tom01 == tom02);

        MyConfig bean = run.getBean(MyConfig.class);
        System.out.println(bean);
        // 如果@Configuration(proxyBeanMethods = true) ，Spring boot总会检查容器内是否在容器中，如果有，则不会创建
        // 以尽量保持单实例
        // 如果false，则否。
        User user01 = bean.user01();
        User user02 = bean.user01();
        System.out.println(user01 == user02);

        User user1 = run.getBean("user01", User.class);
        Pet tom = run.getBean("tom", Pet.class);
        System.out.println("查看user的宠物，是否是容器里面的宠物proxyBeanMethods = true");
        System.out.println(tom == user1.getPet());
    }
}
