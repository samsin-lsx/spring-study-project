package com.atguigu.spring5.aop.annotation;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 说明：AOP测试类
 * @author：李尚兴
 * @date：2021-05-29 20:56
 * @version：1.0
 */
public class AopAnnotationTest {
    /**
     * 测试AOP注解方式
     */
    @Test
    public void testAopAnnotation() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringAopConfig.class);
        DeptService deptService = context.getBean("deptService", DeptService.class);
        deptService.add();
    }
}
