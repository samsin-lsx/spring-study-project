package com.atguigu.spring5.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 说明：雇员接口代理类
 *
 * @author：李尚兴
 * @date：2021-05-28 23:26
 * @version：1.0
 */
public class EmpDAOProxy implements InvocationHandler {
    private Object object;

    // 传入被代理的实现类对象，即真实业务处理类对象
    public EmpDAOProxy(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("【方法执行之前】" + method.getName() + "()方法调用，传递的参数：" + Arrays.asList(args));
        Object invoke = method.invoke(object, args); // 被增强的目标方法执行
        System.out.println("【方法执行之后】" + object);
        return invoke;
    }
}
