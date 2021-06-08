package com.atguigu.spring5;

import com.atguigu.spring5.config.SpringConfig;
import com.atguigu.spring5.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 说明：注解方法实现对象创建
 * @author：李尚兴
 * @date：2021-05-27 0:18
 * @version：1.0
 */
public class AnnotationTest {
    @Test
    public void testUserService() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-annotation.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.add();
    }

    /**
     * 使用SpringConfig配置类的方法替代spring-annotation.xml配置文件
     */
    @Test
    public void testUserServiceSpringConfig() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserService userService = context.getBean("userService", UserService.class);
        userService.add();
    }
}
