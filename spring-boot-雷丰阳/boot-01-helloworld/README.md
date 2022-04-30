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

默认情况下，spring boot只扫描主程序所在的包及下级，
如需修改可以在
@SpringBootApplication(scanBasePackages = "com.bai")
或者@ComponentsScan()指定扫描路径

# P118 基础入门：spring boot自动配置

各项配置拥有默认值，默认配置最终都是映射到MultipartProperties类