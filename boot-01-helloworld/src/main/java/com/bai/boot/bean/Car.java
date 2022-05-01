package com.bai.boot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component // 只有在容器中的组件才有Spring boot提供的强大功能
@ConfigurationProperties(prefix = "mycar")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Car {
    private String brand;
    private Integer price;


}
