

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