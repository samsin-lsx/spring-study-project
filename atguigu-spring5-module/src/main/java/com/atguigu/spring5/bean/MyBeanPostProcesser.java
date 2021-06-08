package com.atguigu.spring5.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * 说明：创建后置处理器实现类
 * @author：李尚兴
 * @date：2021-05-26 10:22
 * @version：1.0
 */
public class MyBeanPostProcesser implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("【在初始化方法之前执行的方法】");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("【在初始化方法之后执行的方法】");
        return bean;
    }
}
