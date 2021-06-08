package com.atguigu.spring5.bean;

/**
 * 说明：订单实体类
 * @author：李尚兴
 * @date：2021-05-26 10:08
 * @version：1.0
 */
public class Orders {
    private String oname;

    public Orders() {
        System.out.println("【第一步】执行无参数的构造方法创建Bean实例");
    }

    public void setOname(String oname) {
        this.oname = oname;
        System.out.println("【第二步】调用setXxx()方法设置属性值");
    }

    /**
     * 执行初始化方法
     */
    public void initMethod() {
        System.out.println("【第三步】执行初始化方法");
    }

    /**
     * 执行对象销毁方法
     */
    public void destroyMethod() {
        System.out.println("【第五步】执行对象销毁的方法");
    }
}
