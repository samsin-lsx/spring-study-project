package com.atguigu.spring5.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 说明：使用配置类替代spring-annotaion.xml配置文件
 * @author：李尚兴
 * @date：2021-05-28 1:18
 * @version：1.0
 */
@Configuration
@ComponentScan(basePackages = {"com.atguigu.spring5"})
public class SpringConfig {
}
