package com.atguigu.spring5.aop.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 说明：部门业务层代理类
 * @author：李尚兴
 * @date：2021-05-29 20:33
 * @version：1.0
 */
@Component
@Aspect // 生成代理对象
@Order(3) // 设置增强类的执行优先类
public class DeptServiceProxy {

    /**
     * 相同切入点抽取
     */
    @Pointcut("execution(* com.atguigu.spring5.aop.annotation.DeptService.add(..))")
    public void executePointcut() {
    }

    /**
     * 前置通知
     */
    @Before("executePointcut()")
    public void before() {
        System.out.println("【前置通知】执行before()方法……");
    }

    /**
     * 后置通知（返回通知）：在方法的返回值返回之后执行，如果抛异常则不会执行
     */
    @AfterReturning("executePointcut()")
    public void afterReturning() {
        System.out.println("【后置返回通知】执行afterReturning()方法……");
    }

    /**
     * 最终通知：在目标方法之后执行，不管是否抛异常都会执行
     */
    @After("executePointcut()")
    public void after() {
        System.out.println("【后置通知】执行after()方法……");
    }

    /**
     * 异常通知
     */
    @AfterThrowing("executePointcut()")
    public void afterThrowing() {
        System.out.println("【异常通知】执行afterThrowing()方法……");
    }

    /**
     * 环绕通知：是在切入点（被增强的方法）之前和之后都做处理的方法
     */
    @Around("executePointcut()")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("【环绕通知之前】执行around()方法……");
        proceedingJoinPoint.proceed(); // 切入点（被增强的方法）执行
        System.out.println("【环绕通知之后】执行around()方法……");
    }
}
