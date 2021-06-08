package com.atguigu.spring5;

import com.atguigu.spring5.bean.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * User类测试
 */
public class UserTest {
    /**
     * Junit测试
     */
    @Test
    public void testAdd() {
        // 1、加载Spring配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-bean.xml");
        // 2、获取配置创建对象
        User user = context.getBean("user", User.class);
        System.out.println(user);
        user.add();
    }
}
