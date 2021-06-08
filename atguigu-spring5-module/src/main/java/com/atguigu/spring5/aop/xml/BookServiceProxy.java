package com.atguigu.spring5.aop.xml;

/**
 * 说明：图层业务层代理增强类
 * @author：李尚兴
 * @date：2021-05-30 10:19
 * @version：1.0
 */
public class BookServiceProxy {
    public void before() {
        System.out.println("【前置通知】BookServiceProxy类中的before方法执行……");
    }
}
