package com.atguigu.spring5.aop.annotation;

import org.springframework.stereotype.Component;

/**
 * 说明：部门业务层
 * @author：李尚兴
 * @date：2021-05-29 20:32
 * @version：1.0
 */
@Component
public class DeptService {
    public void add() {
        //System.out.println(1 / 0);
        System.out.println("执行add()方法……");
    }
}
