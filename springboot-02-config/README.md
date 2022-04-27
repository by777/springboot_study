# spring-boot配置项

spring支持yaml和properties配置

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

yaml可以直接给实体类赋值。
在建立实体类时,用integer这个包装类比较好

在数据库中，数据的默认值是 null，而在 Java 中，基本类型的默认值不是 null，

例如，int 类型的默认值是 0，而包装类Integer的默认值是 null，因为是对象。

简单来说就是我们如果自定义了一个Student类,其中有一个属性成绩score，
如果用Integer而不用int定义,一次考试，学生可能没考，值是null，也可能考了，但考了0分，值是0，
这两个表达的状态明显不一样。

