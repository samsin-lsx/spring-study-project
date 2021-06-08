package com.atguigu.spring5.aop.xml;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 说明：AOP实现XML配置方式
 * @author：李尚兴
 * @date：2021-05-30 10:27
 * @version：1.0
 */
public class AopXMLTest {
    @Test
    public void testAopXML() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-aop.xml");
        BookService bookService = context.getBean("bookService", BookService.class);
        bookService.buy();
    }
}
