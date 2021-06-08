package com.atguigu.spring5.dao;

import org.springframework.stereotype.Repository;

/**
 * 说明：使用JPA方式实现用户接口操作
 * @author：李尚兴
 * @date：2021-05-28 0:50
 * @version：1.0
 */
@Repository
public class UserJpaDAOImpl implements UserDAO {
    @Override
    public void add() {
        System.out.println("【UserDAO实现】使用JPA方式实现......");
    }
}
