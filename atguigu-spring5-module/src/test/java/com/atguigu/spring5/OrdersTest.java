package com.atguigu.spring5;

import com.atguigu.spring5.bean.Orders;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 说明：订单测试类
 * @author：李尚兴
 * @date：2021-05-26 10:16
 * @version：1.0
 */
public class OrdersTest {
    @Test
    public void testLife() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-bean.xml");
        Orders orders = context.getBean("orders", Orders.class);
        System.out.println("【第四步】获取创建Bean对象实例");
        System.out.println(orders);
        context.close(); // 手动让Bean实例销毁
    }
}
