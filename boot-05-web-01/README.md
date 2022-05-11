# 静态资源目录

+ /static
+ /public
+ /resources
+ /META-INF/resources

请求进来，先去找Controller看能不能处理，不能处理的请求交给静态资源处理器
可以配置静态资源前缀:spring.mvc.static-path-pattern=/res/**
以后访问，当前项目+static+path+pattern+静态资源名=静态资源文件夹下找
localhost:8080/res/bug.jpeg
改变静态资源的默认存放路径
spring.resources.static_locations=classpath:/${static_resource}

pom.xml导入jquery依赖

开启RESTFUL风格表单

```yaml
spring:
  mvc:
    hiddenmethod:
      filter:
        enabled: true
```

```html
<h3>测试REST风格请求</h3>
<form action="/user" method="get">

    <input value="REST - GET提交" type="submit">
</form>


<form action="/user" method="post">
    <input value="REST - POST提交" type="submit">
    <input name="_method" value="POST" type="hidden">
</form>

<form action="/user" method="post">
    <input value="REST - PUT提交" type="submit">
    <input name="_method" value="put" type="hidden">
</form>

<form action="/user" method="post">
    <input value="REST - DELETE提交" type="submit">
    <input name="_method" value="DELETE" type="hidden">
</form>
```

# P140 普通参数与基本注解

# P154 视图解析与模板引擎

spring boot默认不支持jsp，需要引入第三方模板引擎技术实现页面渲染

## 模板引擎-Thymeleaf

Thymeleaf是一个服务端的java开发引擎，语法贴近jsp比较简单，但是非高并发。
自动配置好的属性