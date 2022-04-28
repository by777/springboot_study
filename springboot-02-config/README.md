

# Integer和int的区别
在建立实体类时，用integer这个包装类比较好

在数据库中，数据的默认值是 null，
而在 Java 中，基本类型int的默认值不是 null
spring支持yaml和properties配置

# spring-boot配置项
```yaml
#YAML支持多种方式书写
# 1.--------------
server:
  port: 8080

# 2.--------------
student:
  name: vaixu
  age: 3

# 4.---------------
student: { name:vaixu, age:3 }

# 5.---------------
pets:
  - dog
  - cat

  # 6.---------------
  pets:[cat, dog, pig]
```

通过yaml可以直接给实体类赋值，通过下方的注解选择properties还是yaml方式。

```java

/*方式1.不推荐：
 * properties文件绑定，不能像YAML一样一键赋值，需要对具体属性使用@Value()赋值
 * @PropertySource(value = "classpath:vaixu.properties")
 */
@Component
@ConfigurationProperties(prefix = "person")//方式二，更简便实用✌
public class Person {
    // @Value("${name}")// SPEL表达式取出配置文件的值(for properties)
    private String name;
    private Integer age;
    private Boolean happy;
    private Date birth;
    private Map<String, Object> maps;
    private List<Object> lists;
    private Dog dog;
    
```
# P10 JSR303校验值

| ——         | @ConfigureProperties  | @Value  |
|:-----------|:----------------------|:--------|
| 功能         | 批量注入配置文件中的属性          | 一个个指定   |
| 松散绑定（松散语法） | 支持                    | 不支持     |
| SpEL       | 不支持                   | 支持      |
| JSP303数据校验 | 支持                    | 不支持     |
| 复杂类型封装     | 支持                    | 不支持     |
+ cp语法只需要写一次，Value需要每个字段都添加
+ 松散绑定：一如yml中写的是last-name，那么它和lastName是一样的，-后面的字符默认大写
+ JSR303数据校验，在字段增添一层过滤器，保证数据的合法性
+ 复杂类型封装，yml中可以封装对象，使用@Value就不支持

@Validated与@Email
```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-validation</artifactId>
</dependency>
```
或(根据spring-boot版本的不同)
```xml
<dependency>
    <groupId>org.hibernate</groupId>
    <artifactId>hibernate-validator</artifactId>
    <version>5.3.6.Final</version>
</dependency>
```
```java
@Email()
private String name;
```
这时，在yml中person.name，必须是email的格式，否则报错：
```yaml
person:
  name: 137395@qq.com
  ...

```
一些常用的注解约束：

```java
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

@NotNull(message = "名字不能为空！")
@Max(value = 120, message = "年龄最大不能超过120！")
@Email(message = "邮箱格式错误！")
// 空检查
@Null // 验证对象是否为空，无法验证长度为0的字符串
@NotBlank // 针对字符串，验证trim长度是否大于0
@NotEmpty // 检查约束元素是否为null或者empty
// 布尔检查
@AssertFalse // 验证boolean是否为False
// 长度检查
@Size(min = 0, max = 10) // 对象长度是否在指定范围
@Length(min=0, max = 10) // 
// 日期检查
@Past // 验证Date和Calendar对象是否在当前时间之前
@Future // ...之后
@Pattern() // String是否符合正则表达式
...
```