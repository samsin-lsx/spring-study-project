package com.atguigu.spring5.jdkproxy;

/**
 * 说明：雇员接口实现类
 * @author：李尚兴
 * @date：2021-05-28 23:23
 * @version：1.0
 */
public class EmpDAOImpl implements EmpDAO {
    @Override
    public int add(int x, int y) {
        System.out.println("【add方法执行】");
        return x + y;
    }

    @Override
    public String update(String id) {
        System.out.println("【update方法执行】");
        return id;
    }
}
