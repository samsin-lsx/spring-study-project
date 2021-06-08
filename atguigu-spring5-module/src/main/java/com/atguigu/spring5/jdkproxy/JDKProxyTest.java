package com.atguigu.spring5.jdkproxy;

import java.lang.reflect.Proxy;

/**
 * 说明：JDK动态代理测试类
 * @author：李尚兴
 * @date：2021-05-28 23:21
 * @version：1.0
 */
public class JDKProxyTest {
    public static void main(String[] args) {
        Class[] interfaces = {EmpDAO.class};
        EmpDAOImpl empDAOImpl = new EmpDAOImpl();
        EmpDAO empDAO = (EmpDAO) Proxy.newProxyInstance(JDKProxyTest.class.getClassLoader(), interfaces, new EmpDAOProxy(empDAOImpl));
        int result = empDAO.add(10, 20);
        System.out.println("【执行结果】result = " + result);
        String updateCount = empDAO.update("111111111");
        System.out.println("【执行结果】updateCount = " + updateCount);
    }
}
