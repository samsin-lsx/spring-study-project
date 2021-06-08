package com.atguigu.spring5.aop.annotation;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 说明：人员业务层代理类，验证AOP切入点增强的优先级
 * @author：李尚兴
 * @date：2021-05-30 10:09
 * @version：1.0
 */
@Component
@Aspect
@Order(1) // 设置增强类的执行优先类
public class PersonServiceProxy {
    /**
     * 前置通知
     */
    @Before("execution(* com.atguigu.spring5.aop.annotation.DeptService.add(..))")
    public void before() {
        System.out.println("【前置通知】**** PersonServiceProxy before()方法执行");
    }
}
