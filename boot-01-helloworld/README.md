# 环境准备

java -version: 1.8.0

mvn -v: 3.6.1

| x      | 地址                                                                        |
|:-------|:--------------------------------------------------------------------------|
| 原代码地址  | https://www.yuque.com/atguigu/springboot/lcfeme                           |
| 原视频地址  | https://www.bilibili.com/video/BV1Et411Y7tQ?p=116                         |
| 官方文档地址 | https://docs.spring.io/spring-boot/docs/current/reference/html/index.html |

# P116修改父工程依赖

> boot-01-helloworld

## 新建mvn项目

```xml

<project>
    <!--    
    父项目一般会说明非常多的依赖，
    子项目只要继承了这个子项目，子项目以后写依赖，就不需要版本号了
    其几乎声明了所有常用的版本号
    
    如果对其自动仲裁的版本不满意，
    可以在pom.xml中添加<properties><mysql.version>5.1.43</></>
    -->
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.3.4.RELEASE</version>
    </parent>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
    </dependencies>
</project>
```

## 构建jar包的插件

```cmd
mvn clean & mvn package
java -jar boot-01-helloworld-1.0-SNAPSHOT.jar
```

```xml

<build>
    <plugins>
        <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
        </plugin>
    </plugins>
</build>
```

# P118 自动装配

```java

@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        // 1.返回我们的IoC容器
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);
        // 2.查看容器里的组件，spring已经配置好了web开发的常见场景
        String[] names = run.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }
    }
}

```

包扫描规则：
默认情况下，spring boot只扫描主程序MainApplication.java所在的包及其下级子包的组件。
如需修改可以在

```java
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "com.bai")
/* 或者@ComponentsScan()指定扫描路径:
 * SpringBootApplication是一个合成注解
 * =================================
 * @SpringBootConfiguration
 * @EnableAutoConfiguration
 * @ComponentScan("com.bai")
 */

```

# P118 基础入门：spring boot自动配置

## NOTE

各项配置拥有默认值，
默认配置最终都是映射到MultipartProperties类。
配置文件的值，最终会绑定到某个类上，这个类会在容器中创建对象。
按需添加所有自动配置项，Spring boot有许多的starter，
引入了该场景才会自动配置。
Spring boot 所有的自动配置都在spring-boot-autoconfigure包里面

# P119 @Configuration详解

添加两个组件User和Pet

```java

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
        System.out.println(tom01 == tom02); // true
    }
}
```

# P119 @Import @Conditional @ImportResource

+ @Component：代表组件
+ @Controller：控制器
+ @Service：业务逻辑组件
+ @Repository：数据库层组件
+ @ComponentScan：配置包扫描
+ @Import：给容器中导入一个组件
    + @Import({User.class, DBHelper.class})可以给容器中自动创建出这两个类型的组件
+ @ConditionalOnXXX：满足指定的条件时，进行组件注入
+ @ImportResource：在配置类上@ImportResource("classpath:beans.xml)就可以把有以前配置文件的bean导入

# P123配置绑定

使用Java读取properties文件的内容，并封装到java bean中。
方式1. 只需要一个注解@ConfigurationProperties就行了
方式2. @EnableConfigurationProperties + @ConfigureProperties

# P127 最佳实践

```xml
<!--dev-tools项目或者页面修改以后：Ctrl+F9；-->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-devtools</artifactId>
    <optional>true</optional>
</dependency>
```

# P130 Spring initializer

+ resources/
    + static/ 存放静态资源css等
    + templates/ web页面