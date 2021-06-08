package com.atguigu.spring5.aop.annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 说明：使用配置类来代替spring配置文件
 * @author：李尚兴
 * @date：2021-05-29 20:38
 * @version：1.0
 */
@Configuration
@ComponentScan(basePackages = {"com.atguigu.spring5.aop.annotation"})
@EnableAspectJAutoProxy // 开启生成代理对象配置
public class SpringAopConfig {
}
